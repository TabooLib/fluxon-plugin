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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.SkullMeta"])
@PlatformSide(Platform.BUKKIT)
object FnSkullMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SkullMeta::class.java)
                .function("owner", returnsObject().noParams()) { it.target?.owner }
                .function("hasOwner", returns(Type.Z).noParams()) { it.target?.hasOwner() }
                .function("setOwner", returnsObject().params(Type.OBJECT)) { it.target?.setOwner(it.getString(0)) }
                .function("owningPlayer", returnsObject().noParams()) { it.target?.owningPlayer }
                .function("setOwningPlayer", returnsObject().params(Type.OBJECT)) { it.target?.setOwningPlayer(it.getRef(0) as OfflinePlayer) }
                .function("ownerProfile", returnsObject().noParams()) { it.target?.ownerProfile }
                .function("setOwnerProfile", returnsObject().params(Type.OBJECT)) { it.target?.setOwnerProfile(it.getRef(0) as PlayerProfile) }
                .function("setNoteBlockSound", returnsObject().params(Type.OBJECT)) { it.target?.setNoteBlockSound(it.getRef(0) as NamespacedKey) }
                .function("noteBlockSound", returnsObject().noParams()) { it.target?.noteBlockSound }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
