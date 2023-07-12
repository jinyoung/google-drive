
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DriveFileManager from "./components/listers/DriveFileCards"
import DriveFileDetail from "./components/listers/DriveFileDetail"

import IndexerIndexManager from "./components/listers/IndexerIndexCards"
import IndexerIndexDetail from "./components/listers/IndexerIndexDetail"

import VideoProcessingVideoManager from "./components/listers/VideoProcessingVideoCards"
import VideoProcessingVideoDetail from "./components/listers/VideoProcessingVideoDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"

import DashboardDashboardManager from "./components/listers/DashboardDashboardCards"
import DashboardDashboardDetail from "./components/listers/DashboardDashboardDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/drives/files',
                name: 'DriveFileManager',
                component: DriveFileManager
            },
            {
                path: '/drives/files/:id',
                name: 'DriveFileDetail',
                component: DriveFileDetail
            },

            {
                path: '/indexers/indices',
                name: 'IndexerIndexManager',
                component: IndexerIndexManager
            },
            {
                path: '/indexers/indices/:id',
                name: 'IndexerIndexDetail',
                component: IndexerIndexDetail
            },

            {
                path: '/videoProcessings/videos',
                name: 'VideoProcessingVideoManager',
                component: VideoProcessingVideoManager
            },
            {
                path: '/videoProcessings/videos/:id',
                name: 'VideoProcessingVideoDetail',
                component: VideoProcessingVideoDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },

            {
                path: '/dashboards/dashboards',
                name: 'DashboardDashboardManager',
                component: DashboardDashboardManager
            },
            {
                path: '/dashboards/dashboards/:id',
                name: 'DashboardDashboardDetail',
                component: DashboardDashboardDetail
            },



    ]
})
