package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.NamespacedKey
import org.bukkit.OfflinePlayer
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.profile.PlayerProfile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.SkullMeta"])
@PlatformSide(Platform.BUKKIT)
object FnSkullMeta {

    val TYPE = Type.fromClass(SkullMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SkullMeta::class.java)
                .function("owner", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.owner) }
                .function("hasOwner", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasOwner() ?: false) }
                .function("setOwner", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.setOwner(it.getString(0)) == true) }
                .function("owningPlayer", returnsObject().noParams()) { it.setReturnRef(it.target?.owningPlayer) }
                .function("setOwningPlayer", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.setOwningPlayer(it.getRef(0) as OfflinePlayer) == true)
                }
                .function("ownerProfile", returnsObject().noParams()) { it.setReturnRef(it.target?.ownerProfile) }
                .function("setOwnerProfile", returnsVoid().params(Type.OBJECT)) { it.target?.setOwnerProfile(it.getRef(0) as PlayerProfile) }
                .function("setNoteBlockSound", returnsVoid().params(Type.OBJECT)) { it.target?.setNoteBlockSound(it.getRef(0) as NamespacedKey) }
                .function("noteBlockSound", returnsObject().noParams()) { it.setReturnRef(it.target?.noteBlockSound) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
