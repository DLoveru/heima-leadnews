// ============  主页路由MODEL  ==================
import Layout from '@/compoents/layouts/layout_main'
import Home from '@/pages/home/index'

let routes = [
    {
        path: '/',
        component: Layout,
        children:[
            {
                path:'/home',
                name:'Home',
                component: Home
            }
        ]
    }
]

export default routes;
