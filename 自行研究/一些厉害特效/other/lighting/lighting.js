/**
 * Created by len on 2019/8/9.
 */


var canvas = document.createElement("canvas");
document.body.appendChild(canvas);
var context = canvas.getContext("2d");
var WIDTH = window.innerWidth;
var HEIGHT = window.innerHeight;
//canvas宽高设置
canvas.width = WIDTH;
canvas.height = HEIGHT;
//背景
var bg_color = [13,54,36,1]
var step = 0;
main();

/**函数定义区域********/
function main(){
    init();
    actions();
    setInterval(actions,200);
}

function init(){
    context.fillStyle ='rgba('+bg_color[0]+','+bg_color[1]+','+bg_color[2]+','+bg_color[3]+')';
    context.fillRect(0,0,WIDTH,HEIGHT);
}
function actions(){
    step++;
    draw();
    blur(context,canvas,1)
    fade(context, '0.18', WIDTH, HEIGHT)
}
function blur(ctx,canvas,amt) {
    ctx.filter = `blur(${amt}px)`
    ctx.drawImage(canvas, 0, 0)
    ctx.filter = 'none'
}

function fade(ctx, amt, width, height) {
    ctx.beginPath();
    ctx.rect(0, 0, width, height)
    ctx.fillStyle = `rgba(${bg_color[0]}, ${bg_color[1]}, ${bg_color[2]}, ${amt})`
    ctx.fill()
}


function draw(){
    context.strokeStyle = `hsla(${step%360},${90}%,${70}%,1)`
    var [p1,p2] = [randPoint(WIDTH,HEIGHT),randPoint(WIDTH,HEIGHT)];
    console.log("p1 ==> ",p1.x," ",p1.y)
    console.log("p2 ==> ",p2.x," ",p2.y)
    var points = createPathPoints(p1,p2);
    linePath(points,context);
    context.stroke();
}
function randPoint(rangeX,rangeY){
    return {x:Math.random()*rangeX,y:Math.random()*rangeY}
}

function linePath(points,ctx) {
    ctx.beginPath()
    ctx.moveTo(points[0].x,points[0].y)
    for(var i=1;i<points.length;i++){
        ctx.lineTo(points[i].x,points[i].y)
        ctx.stroke()
    }
}

function createPathPoints(p1,p2){
    var degree = 6;
    var points = [p1,p2];
    var range = 50;
    var iterations = [p1, p2]
    var newiterations, i, j
    for (i = 0; i < degree; i++) {
        newiterations = [iterations[0]]
        for(j = 1; j < iterations.length; j++) {
            newiterations.push(createMidRandPoint(iterations[j-1],iterations[j],1000/(i*i*i+1)))
            newiterations.push(iterations[j])
        }
        iterations = newiterations.concat([])
    }
    return iterations;
    return points;
}

function createMidRandPoint(p1,p2,range){
    // var n = {x:p2.x - p1.x, y:p2.y - p1.y }//垂直向量
    var n = {x:p2.y - p1.y, y:- p2.x + p1.x }//垂直向量
    var mid = {x:0.5*(p2.x + p1.x), y:0.5*(p2.y + p1.y) }//终点坐标
    var l = Math.sqrt(n.x*n.x+n.y*n.y)
    n ={x:n.x/l, y:n.y/l }//转单位向量
    //在垂直向量方向平移一段距离
    var offset = Math.random() * range - range/2
    console.log("offset ",offset)
    n ={x:n.x*offset, y:n.y*offset }//转单位向量
    //中点结合向量n的偏移点
    return {x:mid.x+n.x, y:mid.y+n.y }
}
document.onmousedown = function(e){
    console.log(e.pageX,e.pageY);
}

