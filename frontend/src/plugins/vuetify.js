import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

const themeColors = {
    surface:'#E48684',
    mainText:'#F4F9FB',
    secondaryText:'#F7E9A0',
    primary: '#F76D6D',
    'primary-darken-1': '#24315E',
    secondary: '#424242',
    'secondary-darken-1': '#212121',
    info: '#2196F3',
    error: '#FF5252',
    warning: '#FFC107',
    success: '#4CAF50',
};

const defaultColors = {
    surface: '#FFFFFF', // 카드 배경색
    mainText:'#000000', // 메인 글자 색
    secondaryText:'#808080', // 서브 글자 색
    primary: '#1976D2', // 버특 및 상단 바 색상
    'primary-darken-1': '#1565C0', // 다이얼로그 상단 바 색상
    secondary: '#424242',
    'secondary-darken-1': '#212121',
    info: '#2196F3',
    error: '#FF5252',
    warning: '#FFC107',
    success: '#4CAF50',
};

Object.keys(themeColors).forEach(key => {
    if (!themeColors[key]) {
        themeColors[key] = defaultColors[key];
    }
});

export default new Vuetify({
    theme: {
        light: true,
        themes: {
            light: themeColors,
        },
    },
});
