local Congrats_EventFrame = CreateFrame("Frame")
Congrats_EventFrame:RegisterEvent("CHAT_MSG_BG_SYSTEM_NEUTRAL")
Congrats_EventFrame:SetScript("OnEvent",
	function(self, event, ...)
		local arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9 = ...
		print(toString(arg1))
	end)