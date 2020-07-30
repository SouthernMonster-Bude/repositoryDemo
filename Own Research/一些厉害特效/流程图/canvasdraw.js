const tableShape = 1, srcFieldShape = 2, methodShape = 3, tarFieldShape = 4, PI = Math.PI;
var iconinfo0, iconinfo1, iconclose0, iconclose1, iconleft, iconright;
let imgsPath = ["img/icon-info-0.png", "img/icon-info-1.png", "img/icon-close-0.png",
    "img/icon-close-1.png",
    "img/icon-back-0.png", "img/icon-forword-0.png", "img/icon-back-1.png", "img/icon-forword-1.png"];
let imgs = [];
var count = 0;
var gap = 0;

// 数据基础部分
var srcElement, tarElement;
var srcColElements = [];
var tarColElements = [];
var methodElements = [];
// hop
var hops = [];
var eles = [];

function init() {
    for (let i = 0; i < imgsPath.length; i++) {
        let im = new Image();
        im.src = imgsPath[i];
        imgs.push(im);
        im.onload = function () {
            count++;
            if (imgs.length == count) {
                iconinfo0 = imgs[0];
                iconinfo1 = imgs[1];
                iconclose0 = imgs[2];
                iconclose1 = imgs[3];
                iconleft = imgs[4];
                iconright = imgs[5];
                iconleft1 = imgs[6];
                iconright1 = imgs[7];
                console.log("图片加载完成00000");
            }
        }
    }
}


class point {
    constructor(x, y, type) {
        this.x = x;
        this.y = y;
        // 字段id
        this.type = type;
    }
    copy() {
        let p = new point(this.x, this.y, this.type);
        return p;
    }
}
class element {
    /**
     * @param {*} id ele-id
     * @param {*} name ele-name
     * @param {*} remark ele-remark
     * @param {*} x x
     * @param {*} y y
     * @param {*} shape 形状
     * @param {*} w 宽
     * @param {*} h 高
     * @param {*} executeMethod 绑定方法
     */
    constructor(id, name, x, y, shape, w, h, executeMethod, ro, co, remark) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.ro = ro;
        this.co = co;
        this.shape = shape;
        this.remark = remark;
        this.name = name;
        this.isActive = false;
        this.isAlive = true;
        this.color = "#f2f2f2";
        this.textcolor ="#000";
        this.executeMethod = executeMethod;
        if (shape == srcFieldShape || shape == methodShape || shape == tarFieldShape) {
            this.left = new point(x - w * 0.65, y, "left");
            this.right = new point(x + w * 0.65, y, "left");
        } else {
            this.left = new point(x - w * 0.5, y, "left");
            this.right = new point(x + w * 0.5, y, "left");
        }
        this.img = {};
        this.img['detail'] = iconinfo0;
        this.img['backword'] = iconleft;
        this.img['foward'] = iconright;
        this.img['close'] = iconclose0;
        this.img['add'] = iconclose0;
    }
    copy() {
        let e = new element(id, name, remark, x, y, shape, w, h, executeMethod);
        return e;
    }
}
class hop {
    constructor(id, start, end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.isAlive = true;
        this.color = "#1890ff";
    }
    copy() {
        let h = new hop(this.id, this.start, this.end);
        return h;
    }
}
class executeMethod {
    constructor(detail, foward, backword, deleted, click, dbclick, addMethod) {
        this.detail = detail;
        this.foward = foward;
        this.backword = backword;
        this.deleted = deleted;
        this.click = click;
        this.dbclick = dbclick;
        this.addMethod = addMethod;
    }
    exec(str, params) {
        console.log("executeMethod", str);
        switch (str) {
            case "detail": this.detail(params, this.then); break;
            case "forward": this.foward(params, this.then); break;
            case "backward": this.backword(params, this.then); break;
            case "deleted": this.deleted(params, this.then); break;
            case "click": this.click(params, this.then); break;
            case "dbclick": this.dbclick(params, this.then); break;
            case "addMethod": this.addMethod(params, this.then); break;
        }
    }
    setThenFunc(then) {
        this.then = then;
    }
}

function drawMethodMenuIconOfEle(ctx, ele) {
    drawCloseIcon(ctx, ele, ele.img.close);
    drawInfoIcon(ctx, ele, ele.img.detail);
    drawDirectIcon(ctx, ele, ele.img.backword);
    drawDirectIcon(ctx, ele, ele.img.foward, 1);
}
function drawTableMenuIconOfEle(ctx, ele) {
    drawInfoIcon(ctx, ele, ele.img.detail);
}
function drawFieldMenuIconOfEle(ctx, ele) {
    drawInfoIcon(ctx, ele, ele.img.detail);
}

function drawElements(ctx, eles) {
    eles.forEach(ele => {
        if (ele.isAlive) {
            drawElement(ctx, ele);
        }
    });
}
function drawElement(ctx, ele) {
    switch (ele.shape) {
        case 1:
            drawTableEle(ctx, ele);
            if (ele.isActive) {
                drawTableMenuIconOfEle(ctx, ele);
            }
            break;
        case 2:
            drawFieldEle(ctx, ele);
            if (ele.isActive) {
                drawFieldMenuIconOfEle(ctx, ele);
            }
            break;
        case 3:
            if (ele.isActive) {
                drawMethodMenuIconOfEle(ctx, ele);
            }
            drawMethodEle(ctx, ele);
            break;
        case 4:
            drawFieldEle(ctx, ele);
            drawAddIcon(ctx, ele, ele.img.add);
            if (ele.isActive) {
                drawFieldMenuIconOfEle(ctx, ele);
            }
            break;
    }
    drawEleText(ctx, ele);
}
function drawTableEle(ctx, ele) {
    ctx.save();
    ctx.beginPath();
    ctx.fillStyle = ele.color;
    ctx.strokeStyle = ele.color;
    ctx.moveTo(ele.x - 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.lineTo(ele.x + 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.lineTo(ele.x + 0.5 * ele.w, ele.y + 0.5 * ele.h);
    ctx.lineTo(ele.x - 0.5 * ele.w, ele.y + 0.5 * ele.h);
    ctx.lineTo(ele.x - 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();
    ctx.restore();
}
function drawFieldEle(ctx, ele) {
    ctx.save();
    ctx.beginPath();
    ctx.fillStyle = ele.color;
    ctx.strokeStyle = ele.color;
    ctx.moveTo(ele.x - 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.lineTo(ele.x + 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.arc(ele.x + 0.5 * ele.w, ele.y, ele.h * 0.5, -0.5 * PI, 0.5 * PI, false);
    ctx.lineTo(ele.x - 0.5 * ele.w, ele.y + 0.5 * ele.h);
    ctx.arc(ele.x - 0.5 * ele.w, ele.y, ele.h * 0.5, 0.5 * PI, 1.5 * PI);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();
    ctx.restore();
}
function drawMethodEle(ctx, ele) {
    ctx.save();
    ctx.beginPath();
    ctx.fillStyle = ele.color;
    ctx.strokeStyle = ele.color;
    ctx.moveTo(ele.x - 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.lineTo(ele.x + 0.5 * ele.w, ele.y - 0.5 * ele.h);
    ctx.arc(ele.x + 0.5 * ele.w, ele.y, ele.h * 0.5, -0.5 * PI, 0.5 * PI, false);
    ctx.lineTo(ele.x - 0.5 * ele.w, ele.y + 0.5 * ele.h);
    ctx.arc(ele.x - 0.5 * ele.w, ele.y, ele.h * 0.5, 0.5 * PI, 1.5 * PI);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();
    ctx.restore();
}
function drawMethodEleFunctionIcon(ctx, ele) {

}
function drawEleText(ctx, ele) {
    ctx.save();
    ctx.fillStyle = ele.textcolor;
    ctx.font = ele.h * 0.75 + "px 微软雅黑";
    ctx.fillText(ele.name, ele.x - 0.4 * ele.w, ele.y + ele.h * 0.3)
    ctx.restore();
}
function drawHops(ctx, hops) {
    hops.forEach(hop => {
        if (hop.isAlive) {
            drawHop(ctx, hop);
        }
    });
}
function drawHop(ctx, hop) {
    let left = hop.start.right;
    let right = hop.end.left;
    ctx.save();
    ctx.beginPath();
    ctx.lineWidth = 3;
    ctx.strokeStyle = hop.color;
    ctx.moveTo(left.x, left.y);
    ctx.lineTo(left.x + 0.5 * (right.x - left.x), left.y);
    ctx.lineTo(left.x + 0.5 * (right.x - left.x), right.y);
    ctx.lineTo(right.x, right.y);
    ctx.stroke();
    // ctx.fill();
    ctx.restore();
    drawArrow(ctx, right.x - 1, right.y, right.x, right.y, 30, 10, 10, hop.color)
}
function lineElement(eleA, eleB) {
    return new hop(0, eleA, eleB);
}
function drawInfoIcon(ctx, ele, img) {
    drawIcon(ctx, ele.x - ele.w * 0.5, ele.y - ele.w * 0.25 - ele.h * 0.5, ele.w * 0.25, img);
}
function drawCloseIcon(ctx, ele, img) {
    drawIcon(ctx, ele.x + ele.w * 0.25, ele.y - ele.w * 0.25 - ele.h * 0.5, ele.w * 0.25, img);
    // drawIcon(ctx, ele.x + ele.w * 0.25, ele.y, ele.w * 0.25, img, 90);
}
function drawDirectIcon(ctx, ele, img, direction) {
    if (direction) {
        drawIcon(ctx, ele.x, ele.y - ele.w * 0.25 - ele.h * 0.5, ele.w * 0.25, img);
    } else {
        drawIcon(ctx, ele.x - ele.w * 0.25, ele.y - ele.w * 0.25 - ele.h * 0.5, ele.w * 0.25, img);
    }
}
function drawAddIcon(ctx, ele, img) {
    let x = ele.x - ele.w * 0.60;
    let h = ele.h * 0.80;
    let y = ele.y - 0.5 * h;
    drawIcon(ctx, x, y, h, img, 90);
    // drawIcon(ctx, x,y, h, img);
}
function drawIcon(ctx, x, y, h, img, theta) {
    // img.onload = function () {
    ctx.save();
    ctx.beginPath();
    ctx.translate(x, y);
    if (theta) {
        ctx.translate(0.5 * h, -0.2 * h);
        // console.log("旋转", theta);
        ctx.rotate(theta * PI / 360);
    }
    ctx.drawImage(img, 0, 0, h, h);
    ctx.restore();
    // }

}

//begin execMethod区域
function createMethodEleExecMethods() {
    return new executeMethod(eleDetails, eleForword, eleBackword, eleDeleted, eleClick, eleDbclick, eleAddMethod);
}
function createEleExecMethods() {
    return new executeMethod(eleDetails, '', '', '', eleClick, eleDbclick);
}
function createTarEleExecMethods() {
    return new executeMethod(eleDetails, '', '', '', eleClick, eleDbclick, eleAddMethod);
}
function eleDetails(ele, then) {
    if (!ele.isActive) {
        return;
    }
    console.log("eleDetails ", ele.name);
    console.log("eleDetails active", ele.name, ele.isActive);
    if (then) { then(); }
}
function eleDeleted(ele, then) {
    if (!ele.isActive) {
        return;
    }
    console.log("eleDeleted ", ele.name);
    console.log("eleDeleted active", ele.name, ele.isActive);
    ele.isAlive = false;

    if (then) { then(); }
}
function eleForword(ele, then) {
    if (!ele.isActive) {
        return;
    }
    console.log("eleForword ", ele.name);
    console.log("eleForword active", ele.name, ele.isActive);
    if (then) { then(); }
}
function eleBackword(ele, then) {
    if (!ele.isActive) {
        return;
    }
    console.log("eleBackword ", ele.name);
    console.log("eleBackword active", ele.name, ele.isActive);
    if (then) { then(); }
}
function eleClick(ele, then) {
    ele.isActive = !ele.isActive;
    console.log("eleClick", ele.name, ele.isActive);
    if (then) { then(); }
}
function eleDbclick(ele, then) {
    console.log("eleDbclick ", ele.name);
    if (then) { then(); }
}
function eleAddMethod(ele, then) {
    if (ele.isAlive) {
        let id = 100;
        let methodEle = new element(id, '新建方法', ele.x - (ele.w + gap), ele.y, methodShape, ele.w, ele.h, createMethodEleExecMethods(), ele.ro, ele.co-1);
        methodElements.push(methodEle);
        // todo 找到同一行有连线的元素 并且将其原有的连线取消 将其新的连线关系连接出来
    }
    console.log("eleDbclick ", ele.name);
    if (then) { then(); }
}



//end execMethod区域

function linePointsPath(ctx, points) {
    ctx.beginPath();
    ctx.moveTo(points[0].x, points[0].y);
    points.array.forEach(p => {
        ctx.lineTo(p.x, p.y);
    });
    ctx.lineTo(points[0].x, points[0].y);
    ctx.closePath();
}

function drawArrow(ctx, fromX, fromY, toX, toY, theta, headlen, width, color) {
    theta = typeof (theta) != 'undefined' ? theta : 30;
    headlen = typeof (theta) != 'undefined' ? headlen : 10;
    width = typeof (width) != 'undefined' ? width : 1;
    color = typeof (color) != 'color' ? color : '#000';
    // 计算各角度和对应的P2,P3坐标
    var angle = Math.atan2(fromY - toY, fromX - toX) * 180 / Math.PI,
        angle1 = (angle + theta) * Math.PI / 180,
        angle2 = (angle - theta) * Math.PI / 180,
        topX = headlen * Math.cos(angle1),
        topY = headlen * Math.sin(angle1),
        botX = headlen * Math.cos(angle2),
        botY = headlen * Math.sin(angle2);
    ctx.save();
    ctx.beginPath();
    var arrowX = fromX - topX,
        arrowY = fromY - topY;
    ctx.moveTo(arrowX, arrowY);
    ctx.moveTo(fromX, fromY);
    ctx.lineTo(toX, toY);
    arrowX = toX + topX;
    arrowY = toY + topY;
    ctx.moveTo(arrowX, arrowY);
    ctx.lineTo(toX, toY);
    arrowX = toX + botX;
    arrowY = toY + botY;
    ctx.lineTo(arrowX, arrowY);
    ctx.strokeStyle = color;
    ctx.lineWidth = width;
    ctx.stroke();
    ctx.restore();
}
// 计算两点距离
function calDistance(p1, p2) {
    return ((p1.x - p2.x) ** 2 + (p1.y - p2.y) ** 2) ** 0.5
}
function clean(ctx) {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
}



