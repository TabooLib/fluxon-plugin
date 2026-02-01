package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.NamespacedKey
import org.bukkit.persistence.PersistentDataContainer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.persistence.PersistentDataContainer"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataContainer {

    val TYPE = Type.fromClass(PersistentDataContainer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataContainer::class.java)
                .function("has", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.has(it.getRef(0) as NamespacedKey)) }
                .function("keys", returnsObject().noParams()) { it.setReturnRef(it.target?.keys) }
                .function("remove", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.remove(it.getRef(0) as NamespacedKey)) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("copyTo", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.copyTo(
                        it.getRef(0) as PersistentDataContainer,
                        it.getBool(1)
                    ))
                }
                .function("adapterContext", returnsObject().noParams()) { it.setReturnRef(it.target?.adapterContext) }
        }
    }
}
