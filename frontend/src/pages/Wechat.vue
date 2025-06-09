<template>
    <div class="wechat">
        <!-- 顶部栏 -->
        <div class="header">
            <!-- 图标 -->
            <div class="icon-container">
                <svg t="1748507024366"  class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10334" width="40" height="40"><path d="M490.684916 156.359281C256.165269 156.359281 64.383234 309.755867 64.383234 501.634326 64.383234 610.634973 126.868113 710.691594 230.678884 775.40424 227.606262 773.488857 225.494778 770.415816 224.753999 767.352292 223.887537 768.541972 221.953407 773.256131 218.857033 779.006383 217.065752 782.332956 214.951892 785.897204 212.584292 789.613841 209.515541 794.431134 206.194743 799.237633 202.873358 803.77396 200.894915 806.476107 199.385181 808.450099 198.588038 809.457524 172.393538 846.514453 195.912543 878.240014 237.91885 864.281028 238.904007 863.944749 240.468491 863.41216 242.667337 862.668117 246.342793 861.42442 250.469427 860.037674 254.950478 858.543831 267.750292 854.276769 280.813441 850.010352 293.359528 846.033927 295.896051 845.229988 298.389767 844.444875 300.83653 843.680116 316.56621 838.763658 329.922562 834.822101 340.069379 832.152296 345.53275 830.714787 349.931698 829.683229 353.049854 829.104939 354.354436 828.862994 355.312446 828.724123 355.799045 828.684232 354.825653 828.76403 353.666503 828.729983 351.271205 828.060274 395.73304 840.491494 442.681213 846.909372 490.684916 846.909372 515.054363 846.909372 539.17115 845.255803 562.858125 841.990612L553.743714 841.264542C587.27542 851.488506 622.974605 856.786459 659.544225 856.786459 693.181558 856.786459 726.090816 852.304522 757.271021 843.619314 754.092157 844.504782 753.608504 844.478091 752.940486 844.368364 754.491872 844.623192 756.826954 845.133168 759.766796 845.870344 765.488513 847.305086 773.068547 849.485235 781.988654 852.233024 783.660815 852.748123 785.371243 853.28047 787.11584 853.828542 794.321124 856.09211 801.796248 858.523923 809.096177 860.956383 813.473523 862.414988 816.808901 863.546001 818.665128 864.183881 860.663463 877.971145 884.367548 846.417249 859.473647 810.157106L858.061678 808.322293C856.808278 806.864525 854.629739 804.067756 852.506478 800.829267 851.198804 798.834746 850.132845 796.983268 849.402965 795.433479 848.88826 798.914448 846.566215 803.916137 841.990053 806.75813 915.30587 761.225855 959.616766 690.536117 959.616766 613.308352 959.616766 565.930919 942.964529 520.637339 912.303541 481.843704L916.899107 494.563385C912.222016 305.709617 721.984814 156.359281 490.684916 156.359281ZM874.458588 502.750536 878.87761 508.341678C903.736413 539.794134 916.986598 575.834235 916.986598 613.308352 916.986598 674.834711 880.94872 732.326397 819.523603 770.474036 802.737889 780.898687 803.163281 797.33264 810.846353 813.646472 812.511881 817.182966 814.544511 820.713465 816.871626 824.262883 820.163834 829.284301 823.400763 833.439809 825.757675 836.181018L824.345705 834.346205C826.245123 837.112873 827.218499 839.100202 827.393889 839.834262 826.869427 837.639217 827.310775 834.026062 830.096989 830.317167 832.870293 826.625461 836.179448 825.20914 838.39741 825.099927 837.62165 825.138126 835.424001 824.758139 832.221342 823.706931 830.525993 823.122175 827.066992 821.949243 822.554587 820.445634 815.038264 817.941067 807.337514 815.435854 799.875177 813.091531 798.056786 812.520277 796.271017 811.964481 794.521489 811.425549 765.181772 802.387618 755.193882 799.883117 745.847847 802.486444 718.393861 810.133719 689.327665 814.092267 659.544225 814.092267 627.172439 814.092267 595.657587 809.415292 566.15969 800.421253L561.682084 799.056011 557.04528 799.695183C535.285067 802.694774 513.110434 804.215178 490.684916 804.215178 446.549157 804.215178 403.457662 798.324515 362.734113 786.938494 351.832032 783.890348 334.145392 788.544012 288.136195 802.924618 285.63427 803.706617 283.086605 804.508715 280.497094 805.329449 267.729439 809.3761 254.472422 813.705833 241.486537 818.034925 236.942593 819.549735 232.755682 820.956737 229.021658 822.220252 226.774814 822.980535 225.182894 823.522465 224.313674 823.819927 221.208111 824.851035 218.947329 825.258295 218.14354 825.226502 220.466916 825.3184 223.929592 826.769872 226.819244 830.667817 229.71253 834.570666 230.098527 838.322463 229.508371 840.593362 229.704432 839.838924 230.732379 837.824526 232.699225 835.037893 233.109594 834.570863 234.938024 832.180175 237.251504 829.020436 241.083328 823.786956 244.915738 818.239954 248.523314 812.576814 251.420355 808.029067 254.057357 803.582735 256.378759 799.271676 270.621662 772.821292 274.586859 752.486106 253.20607 739.157937 161.261462 681.842314 107.013402 594.975258 107.013402 501.634326 107.013402 335.711853 277.868719 199.053473 490.684916 199.053473 700.625512 199.053473 870.235026 332.209541 874.282045 495.621998L874.458588 502.750536ZM874.35643 501.634326 916.986598 501.634326C916.986598 499.274725 916.957412 496.917663 916.899107 494.563385L874.282045 495.621998C874.331614 497.623493 874.35643 499.627657 874.35643 501.634326ZM557.04528 799.695183 559.951702 820.842898 566.15969 800.421253C467.508194 770.341978 402.101853 695.9473 402.101853 613.308352 402.101853 503.628141 516.430046 412.524437 659.544225 412.524437 750.184557 412.524437 832.352401 449.475927 878.87761 508.341678L912.303541 481.843704C857.398565 412.375501 762.792042 369.830244 659.544225 369.830244 494.751422 369.830244 359.471685 477.629422 359.471685 613.308352 359.471685 716.357726 438.355709 806.082232 553.743714 841.264542L558.221321 842.629784 562.858125 841.990612C564.566072 841.755176 566.271624 841.511382 567.974711 841.259249L561.740762 799.024014C560.177951 799.255379 558.612768 799.479109 557.04528 799.695183Z" fill="#2c2c2c" p-id="10335"></path></svg>
            </div>
                <!-- 欢迎字段 -->
            <h1 class="header_1">欢迎来到聊天室,{{userInfo.nickname}}</h1>
            <!-- 头像放置地点 -->
            <div class="touxiang" @click="goProfile" style="cursor:pointer;">
                <img :src="avatarUrl" alt="头像" class="touxiang-img" />
            </div>
            <!-- 分割线 -->
            <el-divider class="divider"/>
        </div>
        
        <!-- 聊天界面 -->
        <div class="chat_room">
            <!-- 左侧朋友列表以及聊天人 -->
            <div class="friend_column">
                
                <div class="search-container">
                    <svg t="1748776993199" class="search-icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2586" width="20" height="20"><path d="M446.112323 177.545051c137.567677 0.219798 252.612525 104.59798 266.162424 241.493333 13.562828 136.895354-78.778182 261.818182-213.617777 289.008485-134.852525 27.203232-268.386263-52.156768-308.945455-183.608889s25.018182-272.252121 151.738182-325.779394A267.235556 267.235556 0 0 1 446.112323 177.545051m0-62.060607c-182.794343 0-330.989899 148.195556-330.989899 330.989899s148.195556 330.989899 330.989899 330.989899 330.989899-148.195556 330.989899-330.989899-148.195556-330.989899-330.989899-330.989899z m431.321212 793.341415a30.849293 30.849293 0 0 1-21.94101-9.102223l-157.220202-157.220202c-11.752727-12.179394-11.584646-31.534545 0.37495-43.50707 11.972525-11.972525 31.327677-12.140606 43.494141-0.37495l157.220202 157.220202a31.036768 31.036768 0 0 1 6.723232 33.810101 31.004444 31.004444 0 0 1-28.651313 19.174142z m0 0" p-id="2587"></path></svg>
                    <input type="text" placeholder="搜索好友或群聊" class="search-input">
                </div>
                <el-divider class="divider-1"/>

                <!-- 功能 -->
                <div class="ability">
                    <div class="ability-item" @click="handleChatClick">
                        <svg t="1748778535458" class="ability_icon_1" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6194" width="35" height="35"><path d="M948.8896 315.5968c-14.1312 0-25.6 11.4688-25.6 25.6v12.2368c0 14.1312 11.4688 25.6 25.6 25.6s25.6-11.4688 25.6-25.6v-12.2368c0-14.1312-11.4688-25.6-25.6-25.6z" fill="#44454A" p-id="6195"></path><path d="M948.8896 408.6784c-14.1312 0-25.6 11.4688-25.6 25.6v43.008c0 54.6304-38.5024 99.7888-88.2176 106.7008V471.552c0-114.2784-89.1392-207.2064-198.656-207.2064H294.5536v-1.792c0-59.392 45.5168-107.7248 101.4784-107.7248h425.8304c55.9616 0 101.4784 48.3328 101.4784 107.7248 0 14.1312 11.4688 25.6 25.6 25.6s25.6-11.4688 25.6-25.6c0-87.6544-68.5056-158.9248-152.6784-158.9248H395.9808c-84.1728 0-152.6784 71.3216-152.6784 158.9248v2.3552c-103.0656 7.4752-184.7808 97.28-184.7808 206.6432v166.5024c0 105.1648 75.4688 192.256 172.9024 205.4656l-0.512 71.7824c-0.0512 8.8064 4.4544 17.0496 11.8784 21.8112 4.1472 2.6624 8.96 3.9936 13.7216 3.9936 3.7888 0 7.5776-0.8192 11.0592-2.5088l194.6112-93.3376h174.1312c109.568 0 198.656-92.9792 198.656-207.2064v-2.4064c77.9776-7.0144 139.4176-75.3152 139.4176-158.3104v-43.008a25.46688 25.46688 0 0 0-25.4976-25.6512z m-165.0176 229.3248c0 86.016-66.1504 156.0064-147.456 156.0064H456.448c-3.84 0-7.6288 0.8704-11.0592 2.5088l-162.9184 78.1312 0.4096-54.8352a25.63072 25.63072 0 0 0-25.6-25.8048c-81.3056 0-147.5072-69.9904-147.5072-156.0064V471.552c0-86.016 66.1504-156.0064 147.5072-156.0064h379.136c81.3056 0 147.456 69.9904 147.456 156.0064v166.4512z" fill="#44454A" p-id="6196"></path><path d="M263.9872 559.616a38.3488 36.5568 90 1 0 73.1136 0 38.3488 36.5568 90 1 0-73.1136 0Z" fill="#44454A" p-id="6197"></path><path d="M404.8896 559.616a38.3488 36.5568 90 1 0 73.1136 0 38.3488 36.5568 90 1 0-73.1136 0Z" fill="#44454A" p-id="6198"></path><path d="M547.072 559.616a38.3488 36.5568 90 1 0 73.1136 0 38.3488 36.5568 90 1 0-73.1136 0Z" fill="#44454A" p-id="6199"></path></svg>
                        <p class="able_1">聊天</p>
                    </div>
                    <div class="ability-item" @click="handleFriendClick">    
                        <svg t="1748841555485" class="ability_icon_2" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13219" width="35" height="35"><path d="M602.487386 567.199183c-124.092249 0-225.063919-100.955296-225.063919-225.047546S478.395136 117.105115 602.487386 117.105115c124.075877 0 225.047546 100.955296 225.047546 225.047546S726.563262 567.199183 602.487386 567.199183L602.487386 567.199183zM602.487386 160.083975c-100.443643 0-182.085058 81.625042-182.085058 182.068685 0 100.395548 81.640392 182.068685 182.085058 182.068685 100.363825 0 182.068685-81.673138 182.068685-182.068685C784.555048 241.707994 702.851211 160.083975 602.487386 160.083975L602.487386 160.083975zM941.776835 906.921491c-11.879562 0-21.473057-9.625218-21.473057-21.505803 0-84.662215-32.969902-164.368558-92.768847-224.391606-8.378831-8.378831-8.378831-21.98471 0-30.363542 8.458649-8.394181 22.032806-8.394181 30.411637 0.064468C925.899216 698.806593 963.282638 789.289374 963.282638 885.415688 963.282638 897.296273 953.656397 906.921491 941.776835 906.921491L941.776835 906.921491zM600.871585 567.567573c-173.642782 0.064468-316.185242 142.655024-316.185242 317.848115 0 11.879562-9.625218 21.505803-21.505803 21.505803s-21.473057-9.625218-21.473057-21.505803c0-198.905142 161.810293-360.76353 360.779903-360.76353 0.671289 0 1.614777 0.048095 2.286066 0.096191 11.416004 1.055029 20.22667 10.889001 19.682271 22.416546C623.94407 559.301306 612.959901 568.782238 600.871585 567.567573L600.871585 567.567573zM353.679693 205.972095c-77.995375 0-141.408637 67.730591-141.408637 151.017482 0 83.319637 63.413262 151.0973 141.408637 151.0973 11.864212 0 21.457708 9.577123 21.457708 21.441335 0 11.879562-9.593496 21.537526-21.457708 21.537526-101.707426 0-184.371124-87.045495-184.371124-194.07616 0-106.951871 82.663698-193.996342 184.371124-193.996342 11.864212 0 21.457708 9.593496 21.457708 21.473057S365.543905 205.972095 353.679693 205.972095L353.679693 205.972095zM353.679693 551.210024c-137.842415 0-249.974261 119.343085-249.974261 266.059612 0 11.879562-9.625218 21.505803-21.505803 21.505803s-21.473057-9.625218-21.473057-21.505803c0-170.396855 131.398656-309.038472 292.953122-309.038472 11.864212 0 21.457708 9.593496 21.457708 21.473057S365.543905 551.210024 353.679693 551.210024L353.679693 551.210024z" p-id="13220"></path></svg>
                        <p class="able_2">好友</p>
                    </div>    
                </div>
                <el-divider/>

                <!-- 功能列表添加好友创建群聊 -->
                <div class="function-list" v-if="showFunctionList">
                    <div class="function-item" @click="handleAddFriend">
                        <svg t="1748841555485" class="function-icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13219" width="24" height="24"><path d="M602.487386 567.199183c-124.092249 0-225.063919-100.955296-225.063919-225.047546S478.395136 117.105115 602.487386 117.105115c124.075877 0 225.047546 100.955296 225.047546 225.047546S726.563262 567.199183 602.487386 567.199183L602.487386 567.199183zM602.487386 160.083975c-100.443643 0-182.085058 81.625042-182.085058 182.068685 0 100.395548 81.640392 182.068685 182.085058 182.068685 100.363825 0 182.068685-81.673138 182.068685-182.068685C784.555048 241.707994 702.851211 160.083975 602.487386 160.083975L602.487386 160.083975zM941.776835 906.921491c-11.879562 0-21.473057-9.625218-21.473057-21.505803 0-84.662215-32.969902-164.368558-92.768847-224.391606-8.378831-8.378831-8.378831-21.98471 0-30.363542 8.458649-8.394181 22.032806-8.394181 30.411637 0.064468C925.899216 698.806593 963.282638 789.289374 963.282638 885.415688 963.282638 897.296273 953.656397 906.921491 941.776835 906.921491L941.776835 906.921491zM600.871585 567.567573c-173.642782 0.064468-316.185242 142.655024-316.185242 317.848115 0 11.879562-9.625218 21.505803-21.505803 21.505803s-21.473057-9.625218-21.473057-21.505803c0-198.905142 161.810293-360.76353 360.779903-360.76353 0.671289 0 1.614777 0.048095 2.286066 0.096191 11.416004 1.055029 20.22667 10.889001 19.682271 22.416546C623.94407 559.301306 612.959901 568.782238 600.871585 567.567573L600.871585 567.567573z" p-id="13220"></path></svg>
                        <span>添加好友或群聊</span>
                    </div>
                    <div class="function-item" @click="handleCreateGroup">
                        <svg t="1748841555485" class="function-icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13219" width="24" height="24"><path d="M602.487386 567.199183c-124.092249 0-225.063919-100.955296-225.063919-225.047546S478.395136 117.105115 602.487386 117.105115c124.075877 0 225.047546 100.955296 225.047546 225.047546S726.563262 567.199183 602.487386 567.199183L602.487386 567.199183zM602.487386 160.083975c-100.443643 0-182.085058 81.625042-182.085058 182.068685 0 100.395548 81.640392 182.068685 182.085058 182.068685 100.363825 0 182.068685-81.673138 182.068685-182.068685C784.555048 241.707994 702.851211 160.083975 602.487386 160.083975L602.487386 160.083975zM941.776835 906.921491c-11.879562 0-21.473057-9.625218-21.473057-21.505803 0-84.662215-32.969902-164.368558-92.768847-224.391606-8.378831-8.378831-8.378831-21.98471 0-30.363542 8.458649-8.394181 22.032806-8.394181 30.411637 0.064468C925.899216 698.806593 963.282638 789.289374 963.282638 885.415688 963.282638 897.296273 953.656397 906.921491 941.776835 906.921491L941.776835 906.921491zM600.871585 567.567573c-173.642782 0.064468-316.185242 142.655024-316.185242 317.848115 0 11.879562-9.625218 21.505803-21.505803 21.505803s-21.473057-9.625218-21.473057-21.505803c0-198.905142 161.810293-360.76353 360.779903-360.76353 0.671289 0 1.614777 0.048095 2.286066 0.096191 11.416004 1.055029 20.22667 10.889001 19.682271 22.416546C623.94407 559.301306 612.959901 568.782238 600.871585 567.567573L600.871585 567.567573z" p-id="13220"></path></svg>
                        <span>创建群聊</span>
                    </div>
                </div>

                <!-- 好友列表 -->
                <div class="friend-list" v-if="showFriendList">
                    <div class="friend-item" v-for="friend in friends" :key="friend.username"
                        @click="goToOtherProfile(friend.username)">
                        <img :src="friend.avatarUrl" alt="头像" class="friend-avatar">
                        <div class="friend-info">
                            <span class="friend-name">{{ friend.nickname }}</span>
                            <span class="friend-status">{{ friend.status == 1 ? '在线' : '离线' }}</span>
                        </div>
                    </div>
                </div>

                <!-- 群聊列表
                <div class="group-list" v-if="showGroupList">
                    <div class="group-item" v-for="group in groups" :key="group.id">
                        <img :src="group.avatar" :alt="group.name" class="group-avatar">
                        <div class="group-info">
                            <span class="group-name">{{ group.name }}</span>
                            <span class="group-members">{{ group.memberCount }}人</span>
                        </div>
                    </div>
                </div> -->

                <!-- 聊天列表 -->
                <div class="group-list" v-if="showGroupList">
                    <div class="group-item" v-for="privateChat in privateChatList" :key="privateChat.username"
                    @click="goToPrivateChat(privateChat.username)">
                        <img :src="privateChat.avatarUrl" :alt="privateChat.username" class="group-avatar">
                        <div class="group-info">
                            <span class="group-name">{{ privateChat.nickname }}</span>
                            <span class="group-members">{{ privateChat.content }}</span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="friend-list" v-if="showGroupList">
                    <div class="g" v-for="friend in friends" :key="friend.username"
                        @click="goToOtherProfile(friend.username)">
                        <img :src="friend.avatarUrl" alt="头像" class="friend-avatar">
                        <div class="friend-info">
                            <span class="friend-name">{{ friend.nickname }}</span>
                            <span class="friend-status">{{ friend.status == 1 ? '在线' : '离线' }}</span>
                        </div>
                    </div>
                </div> -->
            
            <!-- 聊天内容区 嵌套路由-->
            <div v-if="showChatPanel" class="chat-panel">
                <!-- 绑定 :key 到当前路由的 fullPath -->
                <router-view :key="$route.fullPath"></router-view>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { getUserInfoApi, getImageApi, getFriendListApi, addFriendApi, getPrivateChatListApi } from '@/request/api'
import { ref, onMounted} from 'vue'
import router from '@/router'
import type { GetUserInfoResponse } from '@/dto/UserDto';
import { useWebSocketStore } from '@/stores/webSocket';
import type { SystemMessage, WebSocketMessage } from '@/dto/MessageDto';


// 控制功能列表显示
const showFunctionList = ref(false)
const showFriendList = ref(false)
const showGroupList = ref(false)
const showChatPanel = ref(true)

interface Friend {
    nickname: string;
    username: string;
    avatar: string;
    status: number;
    avatarUrl : string
}
const friends = ref<Friend[]>([])

interface PrivateChat{
    nickname: string;
    username: string;
    avatar:string;
    content: string; // 最近一条消息内容
    avatarUrl: string; // 好友头像URL
}

const privateChatList = ref<PrivateChat[]>([])

const groups = ref([
    { id: 1, name: '技术交流群', avatar: 'https://placeholder.com/50', memberCount: 10 },
    { id: 2, name: '学习小组', avatar: 'https://placeholder.com/50', memberCount: 5 },
])

const chatInput = ref('')
const chatMessages = ref([
    { from: 'other', text: '你好，欢迎使用聊天室！' },
    { from: 'me', text: '你好！' }
])

// 用户信息数据
const userInfo = ref<GetUserInfoResponse>({
  avatar: 'https://picsum.photos/200/200',
  username: 'test_user',
  email: 'test@example.com',
  nickname: '测试用户',
  gender: 'male', // male 或 female
  age: 25,
  signature: '生活不止眼前的苟且，还有诗和远方',
  status : 0
})

const avatarUrl = ref<string>('https://picsum.photos/200/200');

// 模拟获取用户信息
const fetchUserInfo = async () => {
  // 这里应该是调用API获取用户信息
  const response = await getUserInfoApi();
  if(response.data.code == 200){
    userInfo.value = response.data.data;
    //获取头像
    const avatarResponse = await getImageApi(response.data.data.avatar);
    avatarUrl.value = URL.createObjectURL(avatarResponse.data);
  } else{
    alert(response.data.message);
  }
}


const fetchFriends = async () => {
    try {
        // 1. 获取当前用户的好友关系
        const response = await getFriendListApi() // 假设有一个API可以获取好友列表
        if(response.data.code === 200) {
            friends.value = response.data.data.map((friend: any) => ({
                nickname: friend.nickname,
                username: friend.username,
                avatar: friend.avatar,
                status: friend.status, // 假设所有好友都是在线状态
                avatarUrl: ''
            }));
            for(let i = 0; i < friends.value.length; i++) {
                // 获取每个好友的头像
                const avatarResponse = await getImageApi(friends.value[i].avatar);
                friends.value[i].avatarUrl = URL.createObjectURL(avatarResponse.data);
            }
            console.log('好友列表获取成功:', friends.value);
        } else {
            console.error('获取好友列表失败:', response.data.message);
        }
    } catch (error) {
        console.error('获取好友列表过程中发生错误:', error);
        // 提供默认数据以便测试
    }
};

//挂载前事件
onMounted(async () => {
    try {
        await connectws();
        await fetchUserInfo();
        await fetchFriends();
        await fetchPrivateChatList();
    } catch (error) {
        console.error('组件初始化失败:', error);
    }
});

const ws = useWebSocketStore();
const connectws = async () => {
    try {
        // 连接WebSocket
        ws.connect();
        console.log('WebSocket连接成功');
    } catch (error) {
        console.error('WebSocket连接失败:', error);
    }
}
//处理连接后信息接受 -- 只处理SYSTEM消息
if (ws.socket) {
    ws.socket.onmessage = (event: MessageEvent) => {
        // const data = event.data;
        const message = <WebSocketMessage<Object>>JSON.parse(event.data);
        // 根据消息类型处理不同的事件
        switch (message.type) {                 
            case 'SYSTEM':
                //系统消息
                const data = message.data as SystemMessage;
                switch(data.type){
                    case 'CONNECTION_STATUS_UPDATE':
                        // 处理连接状态更新
                        console.log('连接状态更新:', data.message);
                        break;
                    case 'FRIEND_STATUS_UPDATE':
                        fetchFriends();
                        break;
                }
            break;
        }
    };
}


// 处理点击好友按钮
const handleFriendClick = () => {
    showFunctionList.value = true
    showFriendList.value = true
    showGroupList.value = false
}

//处理好友路由跳转
const goToOtherProfile = (username: string) => {
    // 跳转到好友个人信息页面
    router.push({ name:'OtherProfile',params: { username } });
}
// 处理添加好友
const handleAddFriend = async () => {
    const name = prompt('请输入好友的用户名')
    let response
    if(name == null || name.trim() === '') {
        alert('用户名不能为空')
        return
    }else{
        //验证是否是群聊id
        if(name.length>5){
            const isGroup = name.substring(0, 5) === 'group'? true : false
            if(isGroup) {
                //添加群聊
                return ;
            }
        }
        //不是群聊id
        //添加好友
        response = await addFriendApi(name)
        if(response.data.code === 200) {
            alert('添加好友成功')
            // 刷新好友列表
            await fetchFriends()
        } else {
            alert(response.data.message)
        }
    }
}

// 处理创建群聊
const handleCreateGroup = () => {
    // TODO: 实现创建群聊功能
    console.log('创建群聊')
}

const handleChatClick = () => {
    showFunctionList.value = false
    showFriendList.value = false
    showGroupList.value = true
    showChatPanel.value = true
    // location.reload(); // 刷新页面以确保聊天界面正确加载
    fetchPrivateChatList(); // 刷新私聊列表
}

const goProfile = () => {
    router.push('/profile')
}


const fetchPrivateChatList = async () => {
    const response = await getPrivateChatListApi();
    if(response.data.code === 200) {
            privateChatList.value = response.data.data.map((PrivateChat: any) => ({
                nickname: PrivateChat.nickname,
                username: PrivateChat.username,
                avatar: PrivateChat.avatar,
                content: PrivateChat.content, // 最近一条消息内容
                avatarUrl: ''
            }));
            for(let i = 0; i < privateChatList.value.length; i++) {
                // 获取每个私聊的头像
                const avatarResponse = await getImageApi(privateChatList.value[i].avatar);
                privateChatList.value[i].avatarUrl = URL.createObjectURL(avatarResponse.data);
            }
            // console.log('私聊列表获取成功:', friends.value);
        } else {
        console.error('获取私聊列表失败:', response.data.message);
    }
}

const goToPrivateChat = (user:string) => {
    // 跳转到私聊页面
    console.log('发起私聊:',user);
  router.push({
    name: 'PrivateChat',
    params: { username: user }
  });
}
</script>

<style scoped>
.icon-container {
    display: inline-block;
    padding: 10px;
    background-color: rgba(255, 255, 255, 0.9);
    border-radius: 50%;
    border: 2px solid #C5E4F7; /* 调整边框颜色和宽度 */
    box-shadow: 0 4px 8px rgba(0, 180, 216, 0.1); /* 调整阴影 */
    margin-bottom: 30px;
    animation: fadeIn 1s ease-out;
    animation: float 5s ease-in-out infinite; /* 应用浮动动画 */
  }

  @keyframes float {
    0%, 100% {
        transform: translateY(0); /* 起始和结束位置 */
        box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1); /* 底部阴影 */
        }
    50% {
        transform: translateY(-5px); /* 最高点位置 */
        box-shadow: 0 20px 25px rgba(0, 0, 0, 0.1); /* 顶部阴影 */
        }
    }

.divider{
    position: absolute;
    top: 60px;
}

.header_1{
    position:relative;
    color: #6AA8D8;
    font-size: 30px;
    top:-110px;
    left:70px;
}

.touxiang{
    position: absolute;
    width: 60px;
    height: 60px;
    top: 10px;
    right: 25px;
    border: 2px solid #C5E4F7; /* 调整边框颜色和宽度 */
    box-shadow: 0 4px 8px rgba(0, 180, 216, 0.1); /* 调整阴影 */
    border-radius: 50%;
    object-fit: cover;
}
.touxiang:hover{
    box-shadow: 0 12px 30px rgba(173,216,230,0.4);
}

/* 聊天容器 */
.chat_room {
    display:flex;
    overflow:hidden;
    position: relative;
    background-color: #ffffff;
    /* 改为相对宽度：占父容器宽度的 80% */
    width: 75vw; 
    /* 改为相对高度：占视口高度的 80% */
    height: 75vh;
    box-shadow: 0 3.5px 3px grey;
    border-radius: 10px;
    /* 移除固定定位，改为居中 */
    top: -59px;
    left: 0px;
    margin: 20px auto; /* 上下边距固定，左右自动居中 */
}


/* 输入框 */
.friend_column{
    width:20vw;
    height:75vh;
    background-color:rgba(236, 245, 255,0.8);
    border-radius:10px 0 0 10px;
}

.search-container {
    display: flex;
    align-items: center;
    position: relative;
    width: 15vw;
    height: 4vh;
    background-color: white;
    left: 20px;
    top: 15px;
    border-radius: 10px;
    border: 2px solid #e5e7e6;
    padding: 0 8px; /* 为图标和文本留出空间 */
    transition: all 0.3s ease;
}

.search-container:hover {
    border-color: #d1d5db;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
}

.search-container:focus-within {
    border-color: #6AA8D8;
    box-shadow: 0 0 0 2px rgba(106, 168, 216, 0.2);
    background-color: #f8fafc;
}

/* 搜索图标 */
.search-icon {
    margin-right: 8px;
    color: #9CA3AF; /* 图标颜色 */
    transition: color 0.3s ease;
}

.search-container:hover .search-icon,
.search-container:focus-within .search-icon {
    color: #6AA8D8; /* 悬停和聚焦时图标颜色 */
}

/* 搜索输入框 */
.search-input {
    flex: 1;
    background: transparent;
    border: none;
    outline: none;
    font-size: 14px;
    color: #374151;
    padding: 2px 0;
}

.search-input::placeholder {
    color: #9CA3AF;
}

.divider-1{
    top:5px;
}

/* 朋友列表 */
.ability{
    display:flex;
    flex-direction:row; /*水平排列 */
    justify-content:space-between;/*两端对齐，实现均分 */
    align-items:center;
    /* padding:; */
    gap:30px;
}

.ability-item {
    display: flex;
    align-items: center;
    gap: 10px; /* 图标和文字之间的间距 */
    /* padding:-10px ; */
    border-radius: 8px;
    transition: background-color 0.3s ease;
    flex:1;
    justify-content:center;
}

.able_1, .able_2 {
    font-size: 14px;
    font-weight:500;
    color: #999;
    margin: 0; /* 移除默认边距 */
}

/* 悬停时文字变黑 */
.ability-item:hover .able_1,
.ability-item:hover .able_2 {
    color: #000; /* 悬停时文字变为黑色 */
    transition: color 0.3s ease; /* 平滑过渡效果 */
    cursor: pointer;
}

.ability_icon_1, .ability_icon_2{
    width:28px;
    height:22px;
    fill:#44454A;
}

/* 功能列表样式 */
.function-list {
    padding: 0;
    background: #fff;
    border-radius: 18px;
    margin: 18px 8px 8px 8px;
    box-shadow: 0 4px 18px 0 rgba(106,168,216,0.10), 0 1.5px 4px 0 rgba(0,0,0,0.04);
    display: flex;
    flex-direction: column;
    align-items: stretch;
    min-width: 180px;
}

.function-item {
    display: flex;
    align-items: center;
    justify-content: flex-start;
    gap: 16px;
    padding: 18px 24px 14px 24px;
    cursor: pointer;
    border-radius: 0;
    border-bottom: 1px solid #f2f4f8;
    font-size: 16px;
    color: #44454A;
    background: transparent;
    transition: background 0.2s, color 0.2s;
}

.function-item:last-child {
    border-bottom: none;
}

.function-item:hover {
    background: #eaf6fd;
    color: #3498db;
}

.function-icon {
    width: 22px;
    height: 22px;
    margin-right: 0;
    color: #6AA8D8;
    flex-shrink: 0;
    display: inline-block;
}

.function-item span {
    font-size: 16px;
    font-weight: 500;
    letter-spacing: 1px;
    color: inherit;
    margin-left: 2px;
}

/* 好友列表样式 */
.friend-list {
    margin-top: 10px;
}

.friend-item {
    display: flex;
    align-items: center;
    padding: 10px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.friend-item:hover {
    background-color: #f5f5f5;
}

.friend-avatar {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-right: 10px;
}

.friend-info {
    display: flex;
    flex-direction: column;
}

.friend-name {
    font-size: 14px;
    color: #333;
}

.friend-status {
    font-size: 12px;
    color: #999;
}

/* 群聊列表样式 */
.group-list {
    margin-top: 10px;
}

.group-item {
    display: flex;
    align-items: center;
    padding: 10px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.group-item:hover {
    background-color: #f5f5f5;
}

.group-avatar {
    width: 40px;
    height: 40px;
    border-radius: 8px;
    margin-right: 10px;
}

.group-info {
    display: flex;
    flex-direction: column;
}

.group-name {
    font-size: 14px;
    color: #333;
}

.group-members {
    font-size: 12px;
    color: #999;
}

/* 聊天内容区样式 */
.chat-panel {
    flex: 1;
    display: flex;
    flex-direction: column;
    background: #fff;
    border-radius: 0 10px 10px 0;
    box-shadow: none;
    padding: 0 0 0 0;
}

.chat-header {
    padding: 18px 0 12px 32px;
    font-size: 20px;
    color: #6AA8D8;
    font-weight: 600;
    border-bottom: 1px solid #f0f0f0;
}

.chat-messages {
    flex: 1;
    padding: 24px 32px;
    overflow-y: auto;
    display: flex;
    flex-direction: column;
    gap: 18px;
}

.chat-message {
    display: flex;
    align-items: flex-end;
    gap: 10px;
}

.chat-message.left {
    flex-direction: row;
}

.chat-message.right {
    flex-direction: row-reverse;
}

.avatar {
    width: 36px;
    height: 36px;
    border-radius: 50%;
    background: #C5E4F7;
    border: 2px solid #6AA8D8;
}

.avatar.self {
    background: #6AA8D8;
    border: 2px solid #C5E4F7;
}

.bubble {
    max-width: 320px;
    padding: 10px 18px;
    border-radius: 18px;
    background: #f5f7fa;
    color: #333;
    font-size: 15px;
    box-shadow: 0 1px 2px rgba(0,0,0,0.03);
}

.chat-message.right .bubble {
    background: #6AA8D8;
    color: #fff;
}

.chat-input-bar {
    display: flex;
    align-items: center;
    padding: 16px 32px;
    border-top: 1px solid #f0f0f0;
    background: #fff;
}

.chat-input {
    flex: 1;
    border: none;
    outline: none;
    font-size: 15px;
    padding: 10px 14px;
    border-radius: 8px;
    background: #f5f7fa;
    margin-right: 12px;
    color: #333;
}

.chat-send {
    background: #6AA8D8;
    color: #fff;
    border: none;
    border-radius: 8px;
    padding: 8px 22px;
    font-size: 15px;
    cursor: pointer;
    transition: background 0.2s;
}

.chat-send:hover {
    background: #3498db;
}

.touxiang-img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    object-fit: cover;
    display: block;
}
</style>