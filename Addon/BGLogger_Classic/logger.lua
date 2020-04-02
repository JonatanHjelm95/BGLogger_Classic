if 1 == 1 then
    -- Encounters initialised at beginning of BG
    local Encounters = {}
    local Encounter = {nil}
    local _frame = CreateFrame("Frame")
    local _frame1 = CreateFrame("Frame")
    local _frame2 = CreateFrame("Frame")
    local inCombatFrame = CreateFrame("Frame")
    local outOfCombatFrame = CreateFrame("Frame")
    local combatEventFrame = CreateFrame("Frame")
    local t0 = time()
    

    _frame1:RegisterEvent("PLAYER_TARGET_CHANGED")
    _frame1:SetScript(
        "OnEvent",
        function(self, event, ...)
            --local map  = SetMapToCurrentZone()
            local targetName, realm = UnitName("target");
            print("Target Changed")
            if realm then
                print("Target: ".. targetName ..'-'.. realm)
            else 
                print("Target: ".. targetName)
            end
            --print(toString(arg1))
        end
    )

-- Damage done function
    if inCombatFrame:RegisterEvent("PLAYER_REGEN_DISABLED") then
        combatEventFrame:RegisterEvent("COMBAT_LOG_EVENT")
        combatEventFrame:SetScript("OnEvent",
            function (self, event, ...)
                local eventInfo = {CombatLogGetCurrentEventInfo()}
                event = {timestamp  = 0, type = '', damage = 0, ability = '', target = ''}
                --print(CombatLogGetCurrentEventInfo())
                -- Timestamp at index 0
                -- Attack Type at index 2
                -- Attacked target at index 9
                -- Damage done at index 12
                -- Ranged damage at index 15
                --print('Type: ' .. eventInfo[2])
                event.timestamp = eventInfo[0]
                event.type = eventInfo[2]
                if eventInfo[2] == 'SWING_DAMAGE' then
                    --print('Damage: ' .. eventInfo[12])
                    event.damage = eventInfo[12]
                    --totalDamage = totalDamage + eventInfo[12]
                else
                    --print('Damage: ' .. eventInfo[15])
                    --print('Ability: ' .. eventInfo[13])
                    event.damage = eventInfo[15]
                    event.ability = eventInfo[13]
                    --totalDamage = totalDamage + eventInfo[15]
                end
                --print('Target: ' .. eventInfo[9])
                event.target = eventInfo[9]
                --Encounter.event = event
                --print('Ranged: ' ..eventInfo[15])
                --print(CombatLogGetCurrentEventInfo())
                Encounter[#Encounter+1]=event
            end
        )
    end

    outOfCombatFrame:RegisterEvent("PLAYER_REGEN_ENABLED")
    outOfCombatFrame:SetScript("OnEvent",
        function (self, event, ...)
            Encounters[#Encounters+1] = Encounter
            Encounter = {}
            local totalDamage = 0
            for index, data in ipairs(Encounters) do
                print(index)
            
                for key, event in pairs(data) do
                    --print('\t', key, event.damage)
                    print('\t', event.damage)
                    if not event.damage == nil then
                        totalDamage = totalDamage + tonumber(event.damage)
                    end
                end
            end
            print('Total Damage: ',totalDamage)
        end
    )

    

    _frame:RegisterEvent("PLAYER_STARTED_MOVING")
    _frame:RegisterEvent("PLAYER_STOPPED_MOVING")
    _frame:SetScript(
        "OnEvent",
        function(self, event, ...)
            local time = time()
            local z = C_Map.GetBestMapForUnit("player");
            local pos = C_Map.GetPlayerMapPosition(z,"player");
            local position = UnitInBattleground("player");
            --print(GetMinimapZoneText())
            
            if(time > t0) then
                print(time-t0)
                t0 = time
                --print(C_Map.GetMapInfo(z).name, math.ceil(pos.x*10000)/100, math.ceil(pos.y*10000)/100)
            end
        end
    )
end