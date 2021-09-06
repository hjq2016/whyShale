import { createApp } from 'vue'
import { ActionBar, ActionBarIcon, ActionBarButton, Divider, Popup, Overlay, Loading, Dialog, ContactCard, Form, AddressEdit, AddressList, Field, CellGroup, Cell, SwipeCell, Icon, Stepper, Card, Checkbox, CheckboxGroup, Button, Swipe, SwipeItem, PullRefresh, List, Tab, Tabs, SubmitBar, Toast, Skeleton } from 'vant'
import App from './App.vue'
import router from './router'
import 'lib-flexible/flexible'
import { Tabbar, TabbarItem } from 'vant';
import { Col, Row } from 'vant';
import { Search } from 'vant';
import { DropdownMenu, DropdownItem } from 'vant';
import { Sidebar, SidebarItem } from 'vant';
import  {Pagination} from 'vant'
import installElementPlus from './plugins/element'



const app = createApp(App);

app.use(router)
app.use(Pagination)


app.use(ActionBarButton)
    .use(ActionBarIcon)
    .use(ActionBar)
    .use(Divider)
    .use(Popup)
    .use(Overlay)
    .use(Loading)
    .use(Dialog)
    .use(Toast)
    .use(ContactCard)
    .use(Form)
    .use(AddressEdit)
    .use(AddressList)
    .use(Field)
    .use(CellGroup)
    .use(Cell)
    .use(SwipeCell)
    .use(Icon)
    .use(Stepper)
    .use(Card)
    .use(Button)
    .use(Swipe)
    .use(SwipeItem)
    .use(PullRefresh)
    .use(List)
    .use(Tab)
    .use(Tabs)
    .use(SubmitBar)
    .use(Checkbox)
    .use(CheckboxGroup)
    .use(Skeleton)

app.use(Tabbar);
app.use(TabbarItem);
app.use(Col);
app.use(Row);
app.use(Search);
app.use(DropdownMenu)
app.use(DropdownItem)
app.use(Sidebar)
app.use(SidebarItem)

app.use(installElementPlus)

app.mount('#app');
