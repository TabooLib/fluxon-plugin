package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.OfflinePlayer
import org.bukkit.SkullType
import org.bukkit.block.BlockFace
import org.bukkit.block.Skull
import org.bukkit.profile.PlayerProfile
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSkullType
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes
import java.util.UUID

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
                .function("owningPlayer", returns(FnOfflinePlayer.TYPE).noParams()) { it.setReturnRef(it.target?.owningPlayer) }
                .function("setOwningPlayer", returnsVoid().params(FnOfflinePlayer.TYPE)) { it.target?.setOwningPlayer(it.getRef(0) as OfflinePlayer) }
                .function("setOwningPlayer", returnsVoid().params(Type.STRING)) { it.target?.setOwningPlayer(Bukkit.getOfflinePlayer(it.getString(0))) }
                .function("setOwningPlayer", returnsVoid().params(StandardTypes.UUID)) { it.target?.setOwningPlayer(Bukkit.getOfflinePlayer(it.getRef(0) as UUID)) }
                .function("ownerProfile", returns(FnPlayerProfile.TYPE).noParams()) { it.setReturnRef(it.target?.ownerProfile) }
                .function("setOwnerProfile", returnsVoid().params(FnPlayerProfile.TYPE)) { it.target?.setOwnerProfile(it.getRef(0) as PlayerProfile) }
                .function("noteBlockSound", returns(FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.noteBlockSound) }
                .function("setNoteBlockSound", returnsVoid().params(FnNamespacedKey.TYPE)) { it.target?.setNoteBlockSound(it.getRef(0) as NamespacedKey) }
                .function("rotation", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setRotation", returnsVoid().params(FnBlockFace.TYPE)) { it.target?.setRotation(it.getRef(0) as BlockFace) }
                .function("setRotation", returnsVoid().params(Type.STRING)) { FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.target?.setRotation(p0) } }
                .function("skullType", returns(FnSkullType.TYPE).noParams()) { it.setReturnRef(it.target?.skullType) }
                .function("setSkullType", returnsVoid().params(FnSkullType.TYPE)) { it.target?.setSkullType(it.getRef(0) as SkullType) }
                .function("setSkullType", returnsVoid().params(Type.STRING)) { it.target?.setSkullType(FnSkullType.enumValue(it.getString(0))) }
        }
    }
}
