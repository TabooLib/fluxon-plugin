package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.block.data.type.NoteBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.NoteBlock"])
@PlatformSide(Platform.BUKKIT)
object FnNoteBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoteBlock::class.java)
                .function("instrument", returnsObject().noParams()) { it.target?.instrument }
                .function("setInstrument", returnsObject().params(Type.OBJECT)) { it.target?.setInstrument(it.getRef(0) as Instrument) }
                .function("note", returnsObject().noParams()) { it.target?.note }
                .function("setNote", returnsObject().params(Type.OBJECT)) { it.target?.setNote(it.getRef(0) as Note) }
        }
    }
}
