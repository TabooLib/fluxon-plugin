package org.tabooproject.fluxon.platform.bukkit.function.adyeshach

import ink.ptms.adyeshach.core.Adyeshach
import ink.ptms.adyeshach.core.entity.EntityInstance
import ink.ptms.adyeshach.core.entity.manager.ManagerType
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.java.Export
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["ink.ptms.adyeshach.core.Adyeshach"])
@PlatformSide(Platform.BUKKIT)
object FunctionAdyeshach {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            exportRegistry.registerClass(AdyeshachApi::class.java)
            registerFunction("aapi", returnsObject().noParams()) { AdyeshachApi }
        }
    }

    object AdyeshachApi {

        @Export
        fun entity(source: Any, id: String): EntityInstance? {
            if (source is Player) {
                return Adyeshach.api().getPrivateEntityManager(source).getEntityById(id).firstOrNull()
            }
            return Adyeshach.api().getPublicEntityManager(ManagerType.valueOf(source.toString().uppercase())).getEntityById(id).firstOrNull()
        }

        @Export
        fun entities(source: Any, id: String): List<EntityInstance> {
            if (source is Player) {
                return Adyeshach.api().getPrivateEntityManager(source).getEntityById(id)
            }
            return Adyeshach.api().getPublicEntityManager(ManagerType.valueOf(source.toString().uppercase())).getEntityById(id)
        }
    }
}