<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/main.css">
    <title>Black Jack</title>
    <#list allCards as card>
        <style>
            #card${card.id}{
                position: absolute;
                left: ${card.value}px;
            }
        </style>
    </#list>
</head>
<body>

<button onclick="location.href='/ui/board/all/stop'">Stop</button>
<br>
<button onclick="location.href='/ui/board/all/new/game'">New Game</button>

<h3>${message}</h3>
<div class="finalMessage">
    <h3>${Finalmessage}</h3>
</div>
<div class="table">
    <div class="board">
        <ul class="dealerCard">
            <#list computerCards as card>
                <li><img src="${card.image}" alt=""></li>
            </#list>
        </ul>
        <br>
        <ul class="myCard">
            <#list gamerCards as card>
                <li><img src="${card.image}" alt=""></li>
            </#list>
        </ul>
    </div>
    <button class="newCards" onclick="location.href='/ui/board/all/newCards'">new cards</button>
    <div class="allCards">
            <button class="giveMe" onclick="location.href='/ui/board/all/give/me'">Give me a card</button>
            <#list allCards as card>
                    <img src="${card.image}" id="card${card.id}" alt="">
            </#list>
        </div>
</div>
</body>
</html>