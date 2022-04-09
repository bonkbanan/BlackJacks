<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sansita+Swashed&display=swap" rel="stylesheet">
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
<div class="header">
    <div class="info">
        <div class="message">
            <h3>${message}</h3>
        </div>
        <div class="finalMessage">
            <h3>${Finalmessage}</h3>
        </div>
    </div>
    <div class="main">
        <div class="buttons">
            <button class="newCards" onclick="location.href='/ui/board/all/stop'">Stop</button>
            <button class="newCards" onclick="location.href='/ui/board/all/newCards'">New cards</button>
        </div>
        <div class="allCards">
            <button class="giveMe" onclick="location.href='/ui/board/all/give/me'">Give me a card</button>
            <#list allCards as card>
                <img src="${card.image}" id="card${card.id}" alt="">
            </#list>
        </div>
    </div>
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

</div>
</body>
</html>