package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Keyed
import org.bukkit.Tag
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Tag"])
@PlatformSide(Platform.BUKKIT)
object FnTag {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tag::class.java)
                .function("isTagged", returns(Type.Z).params(Type.OBJECT)) { (it.target as? Tag<Keyed>)?.isTagged(it.getRef(0) as Keyed) }
                .function("values", returnsObject().noParams()) { it.target?.getValues() }
        }
    }
}
