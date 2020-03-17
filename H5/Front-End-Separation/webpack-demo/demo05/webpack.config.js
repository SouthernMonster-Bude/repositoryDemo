

const { resolve } = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'build.js',
        path: resolve(__dirname, 'build')
    },
    module: {
        rules: [
            {
                test: /\.less/,
                use: ['style-loader', 'css-loader', 'less-loader']
            },
            //处理样式文件中的图片 处理不了html中的图片
            {
                test: /\.(jpg|png|gif)/,
                //使用一个loader
                //需要使用url-loader file-loader
                loader: 'url-loader',
                options: {
                    //图片大小小于8kb就会base64处理
                    //优点减少请求数量 减轻服务器压力
                    //缺点 图片体积会更大 文件请求速度更慢
                    limit: 8 * 1024,//8k
                    //问题 url-loader默认使用es6语法解析的
                    //而 html -loader使用的commonjs
                    //解析时会出现问题
                    //解决办法 关闭url-loader es6的模块化 使用commonjs解析
                    esModule: false,
                    //给打包的图片重命名
                    //[hash:10].[ext] 截取hash值前10位，并使用原扩展名
                    name: '[hash:10].[ext]'
                }

            },
            //处理html文件的img
            {
                test: /\.html/,
                loader: 'html-loader'
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/index.html'
        })
    ],
    mode: 'development'
}