package org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.conversations.Conversation\$ConversationState"])
@PlatformSide(Platform.BUKKIT)
object FnConversationConversationState : FnEnumGetter<org.bukkit.conversations.Conversation.ConversationState>() {

    override val enumClass: Class<org.bukkit.conversations.Conversation.ConversationState> = org.bukkit.conversations.Conversation.ConversationState::class.java
}
