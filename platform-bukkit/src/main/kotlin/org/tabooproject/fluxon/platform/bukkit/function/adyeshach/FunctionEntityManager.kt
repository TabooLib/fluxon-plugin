package org.tabooproject.fluxon.platform.bukkit.function.adyeshach

import ink.ptms.adyeshach.core.entity.manager.Manager
import ink.ptms.adyeshach.core.entity.manager.PlayerManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
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
                .function("owner", returnsObject().noParams()) {
                    it.target?.owner
                }
            registerExtension(Manager::class.java)
                .function("isValid", returns(Type.Z).noParams()) {
                    it.target?.isValid()
                }
                .function("isPublic", returns(Type.Z).noParams()) {
                    it.target?.isPublic()
                }
                .function("isTemporary", returns(Type.Z).noParams()) {
                    it.target?.isTemporary()
                }
                .function("entity", returnsObject().params(Type.STRING)) {
                    it.target?.getEntityById(it.getString(0)!!)?.firstOrNull()
                }
                .function("entities", returns(Type.LIST).noParams()) {
                    it.target?.getEntities()
                }
                .function("entities", returns(Type.LIST).params(Type.STRING)) {
                    it.target?.getEntityById(it.getString(0)!!)
                }
        }
    }
}