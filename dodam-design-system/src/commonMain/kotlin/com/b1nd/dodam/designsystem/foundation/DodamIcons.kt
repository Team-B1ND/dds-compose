package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.b1nd.dodam.designsystem.resources.Res
import com.b1nd.dodam.designsystem.resources.ic_arrow_left
import com.b1nd.dodam.designsystem.resources.ic_bell
import com.b1nd.dodam.designsystem.resources.ic_bus
import com.b1nd.dodam.designsystem.resources.ic_calendar
import com.b1nd.dodam.designsystem.resources.ic_checkmark
import com.b1nd.dodam.designsystem.resources.ic_checkmark_circle
import com.b1nd.dodam.designsystem.resources.ic_checkmark_circle_filled
import com.b1nd.dodam.designsystem.resources.ic_chevron_left
import com.b1nd.dodam.designsystem.resources.ic_chevron_right
import com.b1nd.dodam.designsystem.resources.ic_close_line
import com.b1nd.dodam.designsystem.resources.ic_dev
import com.b1nd.dodam.designsystem.resources.ic_door_open
import com.b1nd.dodam.designsystem.resources.ic_exclamationmark_circle
import com.b1nd.dodam.designsystem.resources.ic_eye
import com.b1nd.dodam.designsystem.resources.ic_eye_slash
import com.b1nd.dodam.designsystem.resources.ic_fork_and_knife
import com.b1nd.dodam.designsystem.resources.ic_gear
import com.b1nd.dodam.designsystem.resources.ic_home
import com.b1nd.dodam.designsystem.resources.ic_magnifyingglass
import com.b1nd.dodam.designsystem.resources.ic_megaphone
import com.b1nd.dodam.designsystem.resources.ic_menu
import com.b1nd.dodam.designsystem.resources.ic_moon_plus
import com.b1nd.dodam.designsystem.resources.ic_note
import com.b1nd.dodam.designsystem.resources.ic_person
import com.b1nd.dodam.designsystem.resources.ic_plus
import com.b1nd.dodam.designsystem.resources.ic_trash
import com.b1nd.dodam.designsystem.resources.ic_xmark_circle
import org.jetbrains.compose.resources.vectorResource

enum class DodamIcons {
    Home,
    ForkAndKnife,
    DoorOpen,
    Calendar,
    MoonPlus,
    Menu,
    XMarkCircle,
    ExclamationMarkCircle,
    Plus,
    Note,
    Bus,
    Megaphone,
    ArrowLeft,
    Bell,
    Eye,
    EyeSlash,
    Checkmark,
    CheckmarkCircle,
    CheckmarkCircleFilled,
    ChevronRight,
    ChevronLeft,
    Trash,
    MagnifyingGlass,
    Gear,
    Person,
    Dev,
    Close;

    val value: ImageVector
        @Composable
        get() = when (this) {

            Home -> vectorResource(Res.drawable.ic_home)
            ForkAndKnife -> vectorResource(Res.drawable.ic_fork_and_knife)
            DoorOpen -> vectorResource(Res.drawable.ic_door_open)
            Calendar -> vectorResource(Res.drawable.ic_calendar)
            MoonPlus -> vectorResource(Res.drawable.ic_moon_plus)
            Menu -> vectorResource(Res.drawable.ic_menu)
            XMarkCircle -> vectorResource(Res.drawable.ic_xmark_circle)
            ExclamationMarkCircle -> vectorResource(Res.drawable.ic_exclamationmark_circle)
            Plus -> vectorResource(Res.drawable.ic_plus)
            Note -> vectorResource(Res.drawable.ic_note)
            Bus -> vectorResource(Res.drawable.ic_bus)
            Megaphone -> vectorResource(Res.drawable.ic_megaphone)
            ArrowLeft -> vectorResource(Res.drawable.ic_arrow_left)
            Bell -> vectorResource(Res.drawable.ic_bell)
            Eye -> vectorResource(Res.drawable.ic_eye)
            EyeSlash -> vectorResource(Res.drawable.ic_eye_slash)
            Checkmark -> vectorResource(Res.drawable.ic_checkmark)
            CheckmarkCircle -> vectorResource(Res.drawable.ic_checkmark_circle)
            CheckmarkCircleFilled -> vectorResource(Res.drawable.ic_checkmark_circle_filled)
            ChevronRight -> vectorResource(Res.drawable.ic_chevron_right)
            ChevronLeft -> vectorResource(Res.drawable.ic_chevron_left)
            Trash -> vectorResource(Res.drawable.ic_trash)
            MagnifyingGlass -> vectorResource(Res.drawable.ic_magnifyingglass)
            Gear -> vectorResource(Res.drawable.ic_gear)
            Person -> vectorResource(Res.drawable.ic_person)
            Dev -> vectorResource(Res.drawable.ic_dev)
            Close -> vectorResource(Res.drawable.ic_close_line)
        }
}
