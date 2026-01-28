package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.MetadataStore
import org.bukkit.metadata.MetadataValue
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.metadata.MetadataStore"])
@PlatformSide(Platform.BUKKIT)
object FnMetadataStore {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MetadataStore::class.java)
                .function("setMetadata", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    (it.target as? MetadataStore<Any>)?.setMetadata(
                        it.getRef(0)!!,
                        it.getString(1)!!,
                        it.getRef(2) as MetadataValue
                    )
                }
                .function("getMetadata", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    (it.target as? MetadataStore<Any>)?.getMetadata(
                        it.getRef(0)!!,
                        it.getString(1)!!
                    )
                }
                .function("hasMetadata", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    (it.target as? MetadataStore<Any>)?.hasMetadata(
                        it.getRef(0)!!,
                        it.getString(1)!!
                    )
                }
                .function("removeMetadata", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    (it.target as? MetadataStore<Any>)?.removeMetadata(
                        it.getRef(0)!!,
                        it.getString(1)!!,
                        it.getRef(2) as Plugin
                    )
                }
                .function("invalidateAll", returnsObject().params(Type.OBJECT)) { it.target?.invalidateAll(it.getRef(0) as Plugin) }
        }
    }
}
