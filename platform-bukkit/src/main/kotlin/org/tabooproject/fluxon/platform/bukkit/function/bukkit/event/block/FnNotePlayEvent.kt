package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.event.block.NotePlayEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnInstrument
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.NotePlayEvent"])
@PlatformSide(Platform.BUKKIT)
object FnNotePlayEvent {

    val TYPE = Type.fromClass(NotePlayEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NotePlayEvent::class.java)
                .function("instrument", returns(FnInstrument.TYPE).noParams()) { it.setReturnRef(it.target?.instrument) }
                .function("note", returns(FnNote.TYPE).noParams()) { it.setReturnRef(it.target?.note) }
                .function("setInstrument", returnsVoid().params(FnInstrument.TYPE)) { it.target?.setInstrument(it.getRef(0) as Instrument) }
                .function("setInstrument", returnsVoid().params(Type.STRING)) { FnInstrument.enumValue(it.getString(0))?.let { instrument -> it.target?.setInstrument(instrument) } }
                .function("setNote", returnsVoid().params(FnNote.TYPE)) { it.target?.setNote(it.getRef(0) as Note) }
        }
    }
}
