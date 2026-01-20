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

@PlatformSide(Platform.BUKKIT)
object FnSkullMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SkullMeta::class.java)
                .function("owner", 0) { it.target?.owner }
                .function("hasOwner", 0) { it.target?.hasOwner() }
                .function("setOwner", 1) { it.target?.setOwner(it.getString(0)) }
                .function("owningPlayer", 0) { it.target?.owningPlayer }
                .function("setOwningPlayer", 1) { it.target?.setOwningPlayer(it.getArgument(0) as OfflinePlayer) }
                .function("ownerProfile", 0) { it.target?.ownerProfile }
                .function("setOwnerProfile", 1) { it.target?.setOwnerProfile(it.getArgument(0) as PlayerProfile) }
                .function("setNoteBlockSound", 1) { it.target?.setNoteBlockSound(it.getArgument(0) as NamespacedKey) }
                .function("noteBlockSound", 0) { it.target?.noteBlockSound }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
