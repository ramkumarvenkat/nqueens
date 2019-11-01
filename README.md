# nqueens

Place N queens on an NxN chess board so that none of them attack each other (the classic n-queens problem). Additionally, please make sure that no three queens are in a straight line at ANY angle, so queens on A1, C2 and E3, despite not attacking each other, form a straight line at some angle.

## Running

-   `./gradlew run -PboardDimension=8` will run the solver for a 8\*8 board. The parameter can be set to different dimensions of the chess board
-   `./gradlew test` will run the tests and the coverage report will be present in `build/reports/tests`

## Codacy report

Can be seen [here](https://app.codacy.com/manual/ramkumarvenkat/nqueens/dashboard). 

TODO: Uploading coverage to codacy seems to give errors unfortunately, needs to be fixed
