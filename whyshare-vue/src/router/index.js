import {createRouter, createWebHashHistory} from "vue-router";

const routes = [
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/home',
        name: 'home',
        component: () => import('@/views/home.vue'),
        meta: {
            index: 1
        },
        children: [
            {
                path: '',
                component: () => import('@/views/pageList.vue'),
            },
            {
                path: '/personalHome',
                name: 'personalHome',
                component: () => import('@/views/PersonalHome.vue'),
                meta: {
                    index: 2
                }
            },
            {
                path: '/creator',
                name: 'creator',
                component: () => import('@/views/Creator.vue'),
                meta: {
                    index: 1
                }
            },
            {
                path: '/write',
                name: 'write',
                component: () => import('@/views/Write.vue'),
                meta: {
                    index: 2
                }
            },
            {
                path: '/test/router',
                component: () => import('@/test/views/RouterTest.vue'),
                meta: {
                    index: 1
                }
            },
            {
                path: '/test/router1',
                component: () => import('@/test/views/RouterTest1.vue'),
            }
        ]

    },
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/Login.vue'),
        meta: {
            index: 1
        }
    },
    {
        path: '/register',
        name: 'register',
        component: () => import('@/views/register.vue'),
        meta: {
            index: 1
        }
    },

];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router