Project Scope

# WoW Addon Project:

## Definition of project:

- Collect data from Battlegrounds via Ingame Lua Addon.
- Sending the data to a REST API.
- Analysing and compare data against players.
- Presenting data on single-page REACT application.

## Features: 
- Hvor meget sloges du omkring objectives.
- Honor/Death Rating.
- Utility Usage.

How to:
Når data kommer ind, deler vi det ud til forskellige tråde så processen i at analysere det ikke bliver for front tung.

[Data]-> {data handler} -> {analyst thread} -> [Analysed package] -> {Sumary thread}


## Lærings mål and where to find them:

### Wishfull programming og abstraction:

Vi skriver vores backend i java, og har tænkt os at implementere wishfull programming og interfaces for at gøre backenden mere abstract og 