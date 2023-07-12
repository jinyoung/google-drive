

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="files"
                        to="/drives/files"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        파일
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="indices"
                        to="/indexers/indices"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        인덱스
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="videos"
                        to="/videoProcessings/videos"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        비디오
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="notifications"
                        to="/notifications/notifications"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        알림
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="dashboards"
                        to="/dashboards/dashboards"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        대시보드
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src="https://oaidalleapiprodscus.blob.core.windows.net/private/org-IsZwoYj8yobpFySuytSuI26N/user-ha9EUDa76s1yoHT6JzgqOaFI/img-pDzsKENa6T3FU3zhxe6ck7V8.png?st=2023-07-12T03%3A36%3A38Z&se=2023-07-12T05%3A36%3A38Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-07-11T21%3A32%3A37Z&ske=2023-07-12T21%3A32%3A37Z&sks=b&skv=2021-08-06&sig=3%2B/ymK2QQPMVG2KPh0bcgMgP2hkhw7KclOZVyk5ZZvc%3D"
                    ></v-img>
                    <div class="App-main-text-overlap">구글 드라이브</div>
                    <div class="App-sub-text-overlap">언제 어디서나 필요한 정보를 간편하게 가져갈 수 있는 서비스! 최신 기술을 활용하여 편리한 사용자 경험을 제공합니다. 언어 및 종류에 제한 없이 모든 정보를 한 곳에서 확인하세요. 어떤 서비스를 원하시든, 저희가 해결해 드립니다. 효율성과 편리함을 경험하세요!</div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: 'https://oaidalleapiprodscus.blob.core.windows.net/private/org-IsZwoYj8yobpFySuytSuI26N/user-ha9EUDa76s1yoHT6JzgqOaFI/img-pDzsKENa6T3FU3zhxe6ck7V8.png?st=2023-07-12T03%3A36%3A38Z&se=2023-07-12T05%3A36%3A38Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-07-11T21%3A32%3A37Z&ske=2023-07-12T21%3A32%3A37Z&sks=b&skv=2021-08-06&sig=3%2B/ymK2QQPMVG2KPh0bcgMgP2hkhw7KclOZVyk5ZZvc%3D',
        aggregate: [
            { 
                title: '파일', 
                description: '사용자가 업로드하는 파일을 나타내는 Aggregate', 
                key: 'files', 
                route: '/drives/files',
                ImageUrl: '',
            },
            { 
                title: '인덱스', 
                description: '파일의 위치를 파일 이름으로 인덱싱하는 Aggregate', 
                key: 'indices', 
                route: '/indexers/indices',
                ImageUrl: '',
            },
            { 
                title: '비디오', 
                description: '업로드된 비디오 파일을 처리하는 Aggregate', 
                key: 'videos', 
                route: '/videoProcessings/videos',
                ImageUrl: '',
            },
            { 
                title: '알림', 
                description: '파일 업로드 및 비디오 처리에 대한 알림을 담당하는 Aggregate', 
                key: 'notifications', 
                route: '/notifications/notifications',
                ImageUrl: '',
            },
            { 
                title: '대시보드', 
                description: '파일 업로드 상태 정보를 표시하는 Aggregate', 
                key: 'dashboards', 
                route: '/dashboards/dashboards',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
