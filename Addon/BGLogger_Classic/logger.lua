local _frame = CreateFrame("Frame")
local _frame1 = CreateFrame("Frame")
local t0 = time()
_frame1:RegisterEvent("PLAYER_TARGET_CHANGED")
_frame1:SetScript(
    "OnEvent",
    function(self, event, ...)
        --local map  = SetMapToCurrentZone()
        local targetName, realm = UnitName("target");
        print("Target Changed")
        if realm then
            print("Target: ".. targetName .. realm)
        else 
            print("Target: ".. targetName)
        end
        --print(toString(arg1))
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
        
        if(time > t0) then
            print(time-t0)
            t0 = time
            print(C_Map.GetMapInfo(z).name, math.ceil(pos.x*10000)/100, math.ceil(pos.y*10000)/100)
        end
    end
)
