
/**
 * webpack.config.js webpack配置文件
 * 作用 只是webpack干那些活
 * 
 * 所有构件工具都是基于nodejs平台运行的 模块化默认采用commonjs
 */
const { resolve } = requrie('path')
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
    module: { rules: [ ] },
    //plugins
    plugins: [ ],
    //模式
    mode: 'development'
    // mode:'production'


}