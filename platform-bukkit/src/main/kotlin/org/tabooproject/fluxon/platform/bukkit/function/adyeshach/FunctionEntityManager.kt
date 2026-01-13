package org.tabooproject.fluxon.platform.bukkit.function.adyeshach

import ink.ptms.adyeshach.core.entity.manager.Manager
import ink.ptms.adyeshach.core.entity.manager.PlayerManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["ink.ptms.adyeshach.core.Adyeshach"])
@PlatformSide(Platform.BUKKIT)
object FunctionEntityManager {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerManager::class.java)
                .function("owner", 0) {
                    it.target?.owner
                }
            registerExtension(Manager::class.java)
                .function("isValid", 0) {
                    it.target?.isValid()
                }
                .function("isPublic", 0) {
                    it.target?.isPublic()
                }
                .function("isTemporary", 0) {
                    it.target?.isTemporary()
                }
                .function("entity", 1) {
                    it.target?.getEntityById(it.getArgument(0).toString())?.firstOrNull()
                }
                .function("entities", listOf(0, 1)) {
                    val id = it.getArgument(0)
                    if (id is String) {
                        it.target?.getEntityById(id)
                    } else {
                        it.target?.getEntities()
                    }
                }
        }
    }
}