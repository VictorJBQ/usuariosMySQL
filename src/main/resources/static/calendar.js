document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');
  var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    selectable: true,
    dateClick: function(info) {
      // Al hacer clic en una fecha, abrir el formulario para agregar una cita
      document.getElementById('eventDate').value = info.dateStr;
      document.getElementById('addEventForm').style.display = 'block';
    },
    eventClick: function(info) {
      // Al hacer clic en una cita, mostrar los detalles de la cita en un cuadro de diálogo
      alert('Título: ' + info.event.title + '\nFecha: ' + info.event.start.toLocaleDateString() + '\nHora: ' + info.event.start.toLocaleTimeString());
    }
  });
  calendar.render();

  // Capturar el evento de envío del formulario
  document.getElementById('addEventForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Obtener los valores del formulario
    var title = document.getElementById('eventTitle').value;
    var date = document.getElementById('eventDate').value;
    var time = document.getElementById('eventTime').value;

    // Crear un objeto Event con los detalles de la cita
    var event = {
      title: title,
      start: date + 'T' + time
    };

    // Agregar la cita al calendario
    calendar.addEvent(event);

    // Ocultar el formulario
    document.getElementById('addEventForm').style.display = 'none';

    // Limpiar los valores del formulario
    document.getElementById('eventTitle').value = '';
    document.getElementById('eventDate').value = '';
    document.getElementById('eventTime').value = '';
  });
});
