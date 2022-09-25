package me.xiaozhangup.didamusic

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.contact.Friend
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.NewFriendRequestEvent
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.utils.info
import java.util.function.Consumer


object DidaMusic : KotlinPlugin(
    JvmPluginDescription(
        id = "me.xiaozhangup.didamusic",
        name = "DidaMusic",
        version = "0.1.0",
    ) {
        author("xiaozhangup")
    }
)

{
    const val rootuser = 3296517911

    override fun onEnable() {
        logger.info { "Plugin loaded" }
        globalEventChannel().subscribeAlways<FriendMessageEvent> {
            sender.sendMessage("Hello!")
        }
        globalEventChannel().subscribeAlways<NewFriendRequestEvent> {
            accept()
            bot.getFriend(rootuser)?.sendMessage("""
                        成功添加了一个好友,详细信息如下:
                        
                        QQ账号: $fromId
                        QQ昵称: $fromNick
                    """.trimIndent())
        }
    }
}