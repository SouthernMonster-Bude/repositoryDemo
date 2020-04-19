var chars = [];
// 实现
function transform(n) {
    //过时的语法
    //return unescape("%u" + n.toString( 16 ));
    //现在使用
    return String.fromCharCode("\\u" + n.toString(16));
}
function printChar() {
    var start = 19968;
    var end = 40869;
    var maxCount = end - start;
    function transform(n) {
        //过时的语法
        //return unescape("%u" + n.toString( 16 ));
        //现在使用
        return String.fromCharCode(parseInt("\\u" + n.toString(16)));
    }
    function print(data) {
        console.log(data);
    }
    function add(data) {
        chars.push(data);
    }
    for (var n = 0; n < maxCount; n++) {
        // print(transform(start + n));
        add(transform(start + n));
    }
}
printChar();


//MID(PHONETIC(Sheet2!$A$1:$A$71),RANDBETWEEN(1,LEN(PHONETIC(Sheet2!$A$1:$A$71))),1)&INDEX(Sheet2!$B$2:Sheet2!$B$20000,RANDBETWEEN(1,20000))&IF(0.5>RAND(),INDEX(Sheet2!$B$2:Sheet2!$B$20000,RANDBETWEEN(1,20000)),"")


