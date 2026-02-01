package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.block.data.type.NoteBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnInstrument
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.library.xseries.NoteBlockMusic

@Requires(classes = ["org.bukkit.block.data.type.NoteBlock"])
@PlatformSide(Platform.BUKKIT)
object FnNoteBlock {

    val TYPE = Type.fromClass(NoteBlock::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoteBlock::class.java)
                .function("instrument", returns(FnInstrument.TYPE).noParams()) { it.setReturnRef(it.target?.instrument) }
                .function("setInstrument", returnsVoid().params(FnInstrument.TYPE)) { it.target?.setInstrument(it.getRef(0) as Instrument) }
                .function("note", returns(FnNote.TYPE).noParams()) { it.setReturnRef(it.target?.note) }
                .function("setNote", returnsVoid().params(FnNote.TYPE)) { it.target?.setNote(it.getRef(0) as Note) }
                .function("setNote", returnsVoid().params(Type.STRING)) { NoteBlockMusic.parseNote(it.getString(0))?.let { p0 -> it.target?.setNote(p0) } }
        }
    }
}
