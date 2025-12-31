package org.tabooproject.fluxon.util

import taboolib.common.platform.ProxyCommandSender
import taboolib.module.chat.colored


/**
 * 发送带前缀的消息
 *
 * @param message 消息
 */
fun ProxyCommandSender.tell(message: String) {
    sendMessage("§8[ §fFluxon §8] §7${message.colored()}")
}