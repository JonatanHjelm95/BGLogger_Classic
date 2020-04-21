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

-- Combat Event logger function
    if inCombatFrame:RegisterEvent("PLAYER_REGEN_DISABLED") then
        combatEventFrame:RegisterEvent("COMBAT_LOG_EVENT")
        combatEventFrame:SetScript("OnEvent",
            function (self, event, ...)
                local eventInfo = {CombatLogGetCurrentEventInfo()}
                event = {timestamp  = 0, type = '', amount = 0, ability = '', target = '', crit = nil}
                --print(CombatLogGetCurrentEventInfo())
                -- Timestamp at index 0
                -- Attack Type at index 2
                -- Attacked target at index 9
                -- amount done at index 12
                -- Ranged amount at index 15
                event.timestamp = eventInfo[1]
                event.type = eventInfo[2]
                if eventInfo[2] == 'SWING_DAMAGE' then
                    event.amount = eventInfo[12]
                    event.crit = eventInfo[21]
                else
                    event.amount = eventInfo[15]
                    event.ability = eventInfo[13]
                    event.crit = eventInfo[21]
                end
                event.target = eventInfo[9]
                -- Appending event to Encounter
                Encounter[#Encounter+1]=event
            end
        )
    end

    outOfCombatFrame:RegisterEvent("PLAYER_REGEN_ENABLED")
    outOfCombatFrame:SetScript("OnEvent",
        function (self, event, ...)
            -- Appending Encounter to Encounter(s) and resetting Encounter
            Encounters[#Encounters+1] = Encounter
            Encounter = {}
            local file = io.open('damageLog.txt', "w")
            file:write('Encounters', "\n")
            for index, data in ipairs(Encounters) do
                --print(index)
                file:write('\t', 'Encounter'.. index, '\n')
                for key, event in pairs(data) do
                    file:write('\t', '\t', 'Timestamp: ' .. event.timestamp .. '\n')
                    file:write('\t', '\t', 'Type: ' .. event.type .. '\n')
                    file:write('\t', '\t', 'amount: ' .. event.amount .. '\n')
                    file:write('\t', '\t', 'Ability: ' .. event.ability .. '\n')
                    file:write('\t', '\t', 'Target: ' .. event.target .. '\n')
                    file:write('\t', '\t', 'crit: ' .. event.crit .. '\n')
                    --print('\t', key, event.amount)
                    --print('\t', event.amount, event.crit)
                end
            end
            file:close()
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