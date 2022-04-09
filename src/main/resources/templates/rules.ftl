<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sansita+Swashed&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/index.css">
    <title>Rules</title>
    <style>
        .board{
            height: 95%;
            padding-top: 0px;
            border-radius: 290px;
            margin-top: 80px;
        }
        .buttons{
            flex-direction: row;
            font-family:"Sansita Swashed";

        }
        button{
            margin-right: 5px;
            height: 60px;
        }

        .start:hover,.rules:hover{
            height: 80px;
        }
        .text{
            margin-top: 50px;
        }
        h3{
            font-family:"Sansita Swashed";
        }

    </style>
</head>
<body>
<div class="table">
    <div class="board">
        <div class="text">
            <ul>
                <li><h3>Each participant attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21.</h3></li>
                <li><h3>Cards from 2 to 10 has as many points, as they write.</h3></li>
                <li><h3>Jack equals 2 points.</h3></li>
                <li><h3>Queen equals 3 points.</h3></li>
                <li><h3>King equals 4 points.</h3></li>
                <li><h3>Ace equals 11 points.</h3></li>
                <li><h3>In the left corner you can see how many points you and your opponent(dealer) have.</h3></li>
                <li><h3>For starting game please press a button "give me a card".</h3></li>
                <li><h3>When you get cards and want to stop, press button "stop".</h3></li>
                <li><h3>If cards out of in the deck, you can press button "give me a card" or "new cards".</h3></li>
                <li><h3>Button "new cards" you can use whenever you want to change deck.</h3></li>
                <div class="buttons">
                    <button class="rules" onclick="location.href='/'">Back to main page</button>
                    <button class="start" onclick="location.href='/ui/board/all'">Start a game</button>
                </div>
            </ul>
        </div>
    </div>
</div>
</body>
</html>