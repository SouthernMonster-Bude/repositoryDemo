/*
    index.js webpack 入口文件   
*/
/**
 * 1.运行指令
 *      开发环境 webpack ./src/index.js -o ./build/build.js --mode=development
 * webpack 会议 ./src/index.js为入口开始打包 打包输出后得到built.js
 * 整体打包环境，是开发环境
 *      生产环境 webpack ./src/index.js -o ./build/build.js --mode=production
 * 
 * 
 * 结论
 * webpack 能处理js json文件 不能处理css img等其他资源
 * 生产环境和开发环境将es6语法模块化编译成浏览器能识别的模块
 * 生产环境比开发环境多了一个压缩过程
 * 
 * */
import data from './data.json'
console.log(data)
function add(x,y){
    return x+y
}
console.log(add(3.5,5))