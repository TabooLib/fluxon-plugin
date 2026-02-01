package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.NamespacedKey
import org.bukkit.OfflinePlayer
import org.bukkit.SkullType
import org.bukkit.block.BlockFace
import org.bukkit.block.Skull
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

@Requires(classes = ["org.bukkit.block.Skull"])
@PlatformSide(Platform.BUKKIT)
object FnSkull {

    val TYPE = Type.fromClass(Skull::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Skull::class.java)
                .function("hasOwner", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasOwner() ?: false) }
                .function("owner", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.owner) }
                .function("setOwner", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.setOwner(it.getString(0)) == true) }
                .function("owningPlayer", returnsObject().noParams()) { it.setReturnRef(it.target?.owningPlayer) }
                .function("setOwningPlayer", returnsVoid().params(Type.OBJECT)) { it.target?.setOwningPlayer(it.getRef(0) as OfflinePlayer) }
                .function("ownerProfile", returnsObject().noParams()) { it.setReturnRef(it.target?.ownerProfile) }
                .function("setOwnerProfile", returnsVoid().params(Type.OBJECT)) { it.target?.setOwnerProfile(it.getRef(0) as PlayerProfile) }
                .function("noteBlockSound", returnsObject().noParams()) { it.setReturnRef(it.target?.noteBlockSound) }
                .function("setNoteBlockSound", returnsVoid().params(Type.OBJECT)) { it.target?.setNoteBlockSound(it.getRef(0) as NamespacedKey) }
                .function("rotation", returnsObject().noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setRotation", returnsVoid().params(Type.OBJECT)) { it.target?.setRotation(it.getRef(0) as BlockFace) }
                .function("skullType", returnsObject().noParams()) { it.setReturnRef(it.target?.skullType) }
                .function("setSkullType", returnsVoid().params(Type.OBJECT)) { it.target?.setSkullType(it.getRef(0) as SkullType) }
        }
    }
}
