package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerBucketEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerBucketEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerBucketEvent {

    val TYPE = Type.fromClass(PlayerBucketEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBucketEvent::class.java)
                .function("bucket", returnsObject().noParams()) { it.setReturnRef(it.target?.bucket) }
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("setItemStack", returnsVoid().params(Type.OBJECT)) { it.target?.setItemStack(it.getRef(0) as ItemStack) }
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
                .function("blockClicked", returnsObject().noParams()) { it.setReturnRef(it.target?.blockClicked) }
                .function("blockFace", returnsObject().noParams()) { it.setReturnRef(it.target?.blockFace) }
                .function("hand", returnsObject().noParams()) { it.setReturnRef(it.target?.hand) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
        }
    }
}
