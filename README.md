Project Scope

WoW Addon Project:

- Collect data from Battlegrounds via Threading
- Comparing data with other players
- Presenting data on single-page application via Java REST API

Features: 
- Hvor meget sloges du omkring objectives.
- Honor/Death Rating.
- Utility Usage.

How to:
Når data kommer ind, deler vi det ud til forskellige tråde så processen i at analysere det ikke bliver for front tung.

[Data]-> {data handler} -> {analyst thread} -> [Analysed package] -> {Sumary thread}
