// Step 1: Create the label element
const label = document.createElement('label');
label.textContent = 'Label: Hello'; // Set label text content
label.setAttribute('for', 'helloInput'); // Set 'for' attribute to match input id

// Step 2: Create the input element
const input = document.createElement('input');
input.setAttribute('type', 'text'); // Set input type
input.setAttribute('id', 'helloInput'); // Set input id to match label 'for' attribute

// Step 3: Create a container div and append label and input
document.getElementById('js_customization_item_').appendChild(label);
document.getElementById('js_customization_item_').appendChild(input);
