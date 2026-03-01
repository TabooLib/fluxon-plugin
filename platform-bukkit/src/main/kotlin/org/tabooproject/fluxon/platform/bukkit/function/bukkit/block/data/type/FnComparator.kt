package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Comparator
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

@Requires(classes = ["org.bukkit.block.data.type.Comparator"])
@PlatformSide(Platform.BUKKIT)
object FnComparator {

    val TYPE = Type.fromClass(Comparator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Comparator::class.java)
                .function("mode", returns(FnComparatorMode.TYPE).noParams()) { it.setReturnRef(it.target?.mode) }
                .function("setMode", returnsVoid().params(FnComparatorMode.TYPE)) { it.target?.setMode(it.getRef(0) as Comparator.Mode) }
                .function("setMode", returnsVoid().params(Type.STRING)) { FnComparatorMode.enumValue(it.getString(0))?.let { p0 -> it.target?.setMode(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Comparator\$Mode"])
@PlatformSide(Platform.BUKKIT)
object FnComparatorMode : FnEnumGetter<Comparator.Mode>() {

    override val enumClass: Class<Comparator.Mode> = Comparator.Mode::class.java
}
