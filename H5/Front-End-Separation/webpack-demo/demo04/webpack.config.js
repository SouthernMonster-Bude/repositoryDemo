
const { resolve } = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'build.js',
        path: resolve(__dirname, 'build')
    },
    module: {
        rules: []
    },
    plugins: [
        //引入 html-webpack-plugin
        //功能 默认会创建一个空的html文件 自动引入打包输出的所有资源
        //需求 需要有结构的html文件
        //注意 此方式需要index.html文件中没有引用过build.js 不然会导致build.js引用两遍
        new HtmlWebpackPlugin({
            template:'./src/index.html'
        })
    ],
    mode: 'development'
}