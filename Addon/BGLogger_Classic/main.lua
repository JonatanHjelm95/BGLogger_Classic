
local _frame = CreateFrame("Frame")
local _frame1 = CreateFrame("Frame")
local t0 = time()
_frame1:RegisterEvent("PLAYER_TARGET_CHANGED")
_frame1:SetScript(
    "OnEvent",
    function(self, event, ...)
        --local map  = SetMapToCurrentZone()
        print("Target Changed")
        --print(toString(arg1))
    end
)

local file = io.open('testLogger.txt', 'w')
file:write('test')
file:close()
