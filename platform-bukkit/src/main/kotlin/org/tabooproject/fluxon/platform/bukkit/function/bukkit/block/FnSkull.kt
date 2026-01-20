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

@PlatformSide(Platform.BUKKIT)
object FnSkull {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Skull::class.java)
                .function("hasOwner", 0) { it.target?.hasOwner() }
                .function("owner", 0) { it.target?.owner }
                .function("setOwner", 1) { it.target?.setOwner(it.getString(0)) }
                .function("owningPlayer", 0) { it.target?.owningPlayer }
                .function("setOwningPlayer", 1) { it.target?.setOwningPlayer(it.getArgument(0) as OfflinePlayer) }
                .function("ownerProfile", 0) { it.target?.ownerProfile }
                .function("setOwnerProfile", 1) { it.target?.setOwnerProfile(it.getArgument(0) as PlayerProfile) }
                .function("noteBlockSound", 0) { it.target?.noteBlockSound }
                .function("setNoteBlockSound", 1) { it.target?.setNoteBlockSound(it.getArgument(0) as NamespacedKey) }
                .function("rotation", 0) { it.target?.rotation }
                .function("setRotation", 1) { it.target?.setRotation(it.getArgument(0) as BlockFace) }
                .function("skullType", 0) { it.target?.skullType }
                .function("setSkullType", 1) { it.target?.setSkullType(it.getArgument(0) as SkullType) }
        }
    }
}
