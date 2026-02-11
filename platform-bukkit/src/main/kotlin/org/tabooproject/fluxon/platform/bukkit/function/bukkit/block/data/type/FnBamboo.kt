package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bamboo
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Bamboo"])
@PlatformSide(Platform.BUKKIT)
object FnBamboo {

    val TYPE = Type.fromClass(Bamboo::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bamboo::class.java)
                .function("leaves", returns(FnBambooLeaves.TYPE).noParams()) { it.setReturnRef(it.target?.leaves) }
                .function("setLeaves", returnsVoid().params(FnBambooLeaves.TYPE)) { it.target?.setLeaves(it.getRef(0) as Bamboo.Leaves) }
                .function("setLeaves", returnsVoid().params(Type.STRING)) { FnBambooLeaves.enumValue(it.getString(0))?.let { p0 -> it.target?.setLeaves(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Bamboo.Leaves"])
@PlatformSide(Platform.BUKKIT)
object FnBambooLeaves : FnEnumGetter<Bamboo.Leaves>() {

    override val enumClass: Class<Bamboo.Leaves> = Bamboo.Leaves::class.java
}