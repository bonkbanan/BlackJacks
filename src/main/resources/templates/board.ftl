<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/main.css">
    <title>Title</title>
</head>
<body>
<button><a href="/ui/board/all/shuffle">shuffle</a></button>
<br>
<button><a href="/ui/board/all/give/me">Give me a card</a></button>
<br>
<button><a href="/ui/board/all/stop">Stop</a></button>
<br>
<button><a href="/ui/board/all/new/game">New game</a></button>

<h3>${message}</h3>
<div class="board">
    <ul class="allCard">
        <#list cards as card>
            <li><img src="${card.image}" alt="" id="card${card.id}"></li>
        </#list>
    </ul>
    <ul class="allCard">
        <#list gamerCards as card>
            <li><img src="${card.image}" alt="" id="card${card.id}"></li>
        </#list>
    </ul>
</div>

</body>
</html>