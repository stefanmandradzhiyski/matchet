# matchet-rest

Programming language: Java 8;

Framework: Spring;

ORM: Hibernate;

Database: MySQL;

Building tool: Gradle;

Additional libraries: ModelMapper;

MatchET is a WEB application that can be used to create your own league, add teams to it and organize matches. 

Leagues:
- POST(v1/api/leagues) - Create specific league;
- GET(v1/api/leagues/{id}) - Read desired league;
- GET(v1/api/leagues) - Read all leagues;
- PUT(v1/api/leagues/{id}) - Update specific league data;
- DELETE(v1/api/leagues/{id}) - Delete specific league.

Teams:
- POST(v1/api/teams) - Create specific team and add it to specific league;
- GET(v1/api/teams/{id}) - Get information for specific team;
- GET(v1/api/teams) - Read all teams;
- GET(v1/api/teams-by-league/{id}) - Read all teams in specific league
- PUT(v1/api/teams/{id}) - Update specific team data;
- DELETE(v1/api/teams/{id}) - Delete specific team.

Matches:
- POST(v1/api/matches) - Create specific match between two teams and add it to specific league;
- GET(v1/api/matches/{id}) - Read spefici match data;
- GET(v1/api/matches) - Read all matches;
- GET(v1/api/matches-by-league/{id}) - Read all matches for specific league;
- GET(v1/api/matches-as-home-team/{id}) - Read all home team matches;
- GET(v1/api/matches-as-away-team/{id}) - Read all away team matches;
- PUT(v1/api/matches/{id}) - Update specific match;
- DELETE(v1/api/matches/{id}) - Delete specific match.
