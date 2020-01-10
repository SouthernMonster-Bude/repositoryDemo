
var hours = [];
for(let i=0;i<1000;i++){
    hours.push(i)
}
var days = [];
for(let i=0;i<1000;i++){
    days.push(i)
}

var data = [
    //[0,0,5],[0,1,1]
]
// for(let i=0;i<40000;i++){
//     data.push([parseInt(randomNormalDistribution()*1000),parseInt(randomNormalDistribution()*1000),1])
// }
function randomNormalDistribution(){
    var u=0.0, v=0.0, w=0.0, c=0.0;
    do{
        //获得两个（-1,1）的独立随机变量
        u=Math.random()*2-1.0;
        v=Math.random()*2-1.0;
        w=u*u+v*v;
    }while(w==0.0||w>=1.0)
    //这里就是 Box-Muller转换
    c=Math.sqrt((-2*Math.log(w))/w);
    //返回2个标准正态分布的随机数，封装进一个数组返回
    //当然，因为这个函数运行较快，也可以扔掉一个
    //return [u*c,v*c];
    return u*c;
}

option = {
    title: {
        text: '正态分布模拟',
        link: ''
    },
    // legend: {
    //     data: ['Punch Card'],
    //     left: 'right'
    // },
    polar: {},
    tooltip: {
        formatter: function (params) {
            return params.value[2] + ' commits in ' + hours[params.value[1]] + ' of ' + days[params.value[0]];
        }
    },
    angleAxis: {
        type: 'category',
        data: hours,
        boundaryGap: false,
        splitLine: {
            show: true,
            lineStyle: {
                color: '#999',
                type: 'dashed'
            }
        },
        axisLine: {
            show: false
        }
    },
    radiusAxis: {
        type: 'category',
        data: days,
        axisLine: {
            show: false
        },
        axisLabel: {
            rotate: 45
        }
    },
    series: [{
        name: 'Punch Card',
        // type: 'scatter',
        type: 'scatter',
        coordinateSystem: 'polar',
        symbolSize: function (val) {
            return val[2] * 2;
        },
        data: data,
        animationDelay: function (idx) {
            return idx * 5;
        }
    }]
};