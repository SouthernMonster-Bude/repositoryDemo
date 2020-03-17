
/**
 * webpack.config.js webpack配置文件
 * 作用 只是webpack干那些活
 * 
 * 所有构件工具都是基于nodejs平台运行的 模块化默认采用commonjs
 * 
 * 使用webpack直接执行
 */
const { resolve } = require('path')
module.exports = {//配置
    //入口
    entry: './src/index.js',
    //输出
    output: {
        //输出文件名
        filename: 'build.js',
        //输出路径
        //__dirname是nodejs的变量 是当前文件的目录的绝对路径
        path: resolve(__dirname, 'build')
    },
    //loader 配置
    module: { rules: [
        //不同文件配置不同文件处理
        //css文件处理
        {
            //匹配
            test: /\.css$/,
            //需要的loader
            use: [
                //use执行的顺序是从下到上
                //创建style标签 将js中的样式资源插入其中，添加到head标签
                'style-loader',
                //将css文件变成commjs模块加载到js中，里面内容是样式字符串
                'css-loader'
            ]
        },
        //处理less文件
        {
            test: /\.less$/,
            use: [
                'style-loader','css-loader',
                //将less文件编译成css文件
                'less-loader'
            ]
        }
     ] },
    //plugins
    plugins: [ ],
    //模式
    mode: 'development'
    // mode:'production'


}