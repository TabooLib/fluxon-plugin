package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import taboolib.platform.util.getMetaFirstOrNull
import taboolib.platform.util.hasMeta
import taboolib.platform.util.removeMeta
import taboolib.platform.util.setMeta
import org.bukkit.metadata.MetadataValue
import org.bukkit.metadata.Metadatable
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

@Requires(classes = ["org.bukkit.metadata.Metadatable"])
@PlatformSide(Platform.BUKKIT)
object FnMetadatable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Metadatable::class.java)
                .function("setMeta", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setMeta(it.getRef(0)!!.toString(), it.getRef(1)!!)
                }
                .function("removeMeta", returnsObject().params(Type.OBJECT)) {
                    it.target?.removeMeta(it.getRef(0)!!.toString())
                }
                .function("hasMeta", returns(Type.Z).params(Type.OBJECT)) {
                    it.target?.hasMeta(it.getRef(0)!!.toString())
                }
                .function("getMeta", returnsObject().params(Type.OBJECT)) {
                    it.target?.getMetaFirstOrNull(it.getRef(0)!!.toString())?.value()
                }
                .function("setMetadata", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setMetadata(
                        it.getString(0)!!,
                        it.getRef(1) as MetadataValue
                    )
                }
                .function("getMetadata", returnsObject().params(Type.OBJECT)) { it.target?.getMetadata(it.getString(0)!!) }
                .function("hasMetadata", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasMetadata(it.getString(0)!!) }
                .function("removeMetadata", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.removeMetadata(
                        it.getString(0)!!,
                        it.getRef(1) as Plugin
                    )
                }
        }
    }
}
