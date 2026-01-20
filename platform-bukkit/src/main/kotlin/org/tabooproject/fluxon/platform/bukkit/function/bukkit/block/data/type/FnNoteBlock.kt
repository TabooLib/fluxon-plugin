package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.block.data.type.NoteBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnNoteBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoteBlock::class.java)
                .function("instrument", 0) { it.target?.instrument }
                .function("setInstrument", 1) { it.target?.setInstrument(it.getArgument(0) as Instrument) }
                .function("note", 0) { it.target?.note }
                .function("setNote", 1) { it.target?.setNote(it.getArgument(0) as Note) }
        }
    }
}
